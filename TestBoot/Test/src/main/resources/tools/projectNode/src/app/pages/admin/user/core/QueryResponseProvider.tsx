import { FC, useContext, useState, useEffect, useMemo } from 'react'
import { useQuery } from 'react-query'
import { createResponseContext, stringifyRequestQuery } from './helpers/helpers'
import { useQueryRequest } from './QueryRequestProvider'
import { initialQueryResponse, initialQueryState, PaginationState } from './helpers/models';
import { getUsers } from './UserAPI';
import { User } from './UserModel';


const QueryResponseContext = createResponseContext<User>(initialQueryResponse)
const useQueryResponse = () => useContext(QueryResponseContext)

const useQueryResponseData = () => {
    const { response } = useQueryResponse()

    if (!response) {
        return []
    }

    return response?.data || []
}

const useQueryResponsePagination = () => {
    const defaultPaginationState: PaginationState = {
        links: [],
        ...initialQueryState,
    }

    const { response } = useQueryResponse()
    if (!response || !response.payload || !response.payload.pagination) {
        return defaultPaginationState
    }

    return response.payload.pagination
}

const useQueryResponseLoading = (): boolean => {
    const { isLoading } = useQueryResponse()
    return isLoading
}

const QueryResponseProvider: FC = ({ children }) => {
    const { state } = useQueryRequest()
    const [query, setQuery] = useState<string>(stringifyRequestQuery(state))
    const updatedQuery = useMemo(() => stringifyRequestQuery(state), [state])

    useEffect(() => {
        if (query !== updatedQuery) {
            setQuery(updatedQuery)
        }
    }, [query, updatedQuery])

    const {
        isFetching,
        refetch,
        data: response,
    } = useQuery(
        `${query}`,
        () => {
            return getUsers(query)
        },
        { cacheTime: 0, keepPreviousData: true, refetchOnWindowFocus: false }
    )

    return (
        <QueryResponseContext.Provider value={{ isLoading: isFetching, refetch, response, query }}>
            {children}
        </QueryResponseContext.Provider>
    )
}


export {
    QueryResponseProvider,
    useQueryResponse,
    useQueryResponseData,
    useQueryResponsePagination,
    useQueryResponseLoading,
}
