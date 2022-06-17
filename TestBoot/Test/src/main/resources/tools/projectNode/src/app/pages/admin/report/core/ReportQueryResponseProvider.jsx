import { useContext, useState, useEffect, useMemo, createContext } from 'react'
import { useQuery } from 'react-query'
import { ReportcreateResponseContext, ReportstringifyRequestQuery } from './helpers/Reporthelpers';
import { ReportinitialQueryResponse, ReportinitialQueryState } from './helpers/Reportmodels';
import { ReportSelectuseQueryRequest, ReportuseQueryRequest } from './ReportQueryRequestProviderReport';
import { getReports, getSelectList } from './ReportAPI';
import ReportSelectionHeader from '../components/table/ReportSelectionHeader';
import ReportSelectionCell from '../components/table/ReportSelectionCell';
import { ReportCustomHeader } from '../components/table/ReportCustomHeader';
import ReportDataCell from '../components/table/ReportDataCell';

const ReportQueryResponseContext = createContext(ReportinitialQueryResponse)
const ReportuseQueryResponse = () => useContext(ReportQueryResponseContext)

const ReportuseQueryResponseData = () => {
    const { response } = ReportuseQueryResponse()

    if (!response) {
        return []
    }
    return response?.data || []
}

const ReportuseQueryResponseColData = () => {
    const { response } = ReportuseQueryResponse()

    if (!response) {
        return []
    }

    const ReportColumn = []
    const keys = Object.keys(response.data[0])
    for (const key of keys) {
        let obj = {}
        if (key === 'id') {
            obj = {
                Header: (props) => <ReportSelectionHeader tableProps={props} />,
                id: key,
                Cell: ({ ...props }) => <ReportSelectionCell id={props.data[props.row.index][key]} />,
            }
        } else {
            obj = {
                Header: (props) => <ReportCustomHeader tableProps={props} title={key} className='min-w-125px' />,
                id: key,
                Cell: ({ ...props }) => <ReportDataCell name={props.data[props.row.index][key]} />,
            }
        }
        ReportColumn.push(obj)
    }

    return ReportColumn || []
}

const ReportuseQueryResponsePagination = () => {
    const defaultPaginationState = {
        links: [],
        ...ReportinitialQueryState,
    }

    const { response } = ReportuseQueryResponse()
    if (!response || !response.payload || !response.payload.pagination) {
        return defaultPaginationState
    }

    return response.payload.pagination
}

const ReportuseQueryResponseLoading = () => {
    const { isLoading } = ReportuseQueryResponse()
    return isLoading
}

const ReportQueryResponseProvider = ({ children }) => {

    const { state } = ReportuseQueryRequest()
    const [query, setQuery] = useState(ReportstringifyRequestQuery(state))
    const updatedQuery = useMemo(() => ReportstringifyRequestQuery(state), [state])
    useEffect(() => {
        if (query !== updatedQuery) {
            setQuery(updatedQuery)
        }
    }, [updatedQuery])


    const {
        isFetching,
        refetch,
        data: response,
    } = useQuery(
        `${query}`,
        () => {
            return getReports(query)
        },
        { cacheTime: 0, keepPreviousData: true, refetchOnWindowFocus: false }
    )


    if (!response) {
        return null
    } //리렌더링 null 데이터 방지

    return (
        <ReportQueryResponseContext.Provider value={{ isLoading: isFetching, refetch, response, query }}>
            {children}
        </ReportQueryResponseContext.Provider>
    )
}

//Select List
const ReportSelectQueryResponseContext = createContext(ReportinitialQueryResponse)
const ReportSelectuseQueryResponse = () => useContext(ReportSelectQueryResponseContext)

const ReportSelectQueryResponseProvider = ({ children }) => {

    const { state } = ReportSelectuseQueryRequest()
    const [query, setQuery] = useState(state)
    const updatedQuery = useMemo(() => state, [state])
    useEffect(() => {
        if (query !== updatedQuery) {
            setQuery(updatedQuery)
        }
    }, [updatedQuery])

    const {
        isFetching,
        refetch,
        data: response,
    } = useQuery(
        `${query}`,
        () => {
            return getSelectList(query)
        },
        { cacheTime: 0, keepPreviousData: true, refetchOnWindowFocus: false }
    )


    if (!response) {
        return null
    } //리렌더링 null 데이터 방지

    return (
        <ReportSelectQueryResponseContext.Provider value={{ isLoading: isFetching, refetch, response, query }}>
            {children}
        </ReportSelectQueryResponseContext.Provider>
    )
}

const ReportSelectuseQueryResponseData = () => {
    const { response } = ReportSelectuseQueryResponse()

    if (!response) {
        return []
    }
    return response?.data || []
}

export {
    ReportQueryResponseProvider,
    ReportuseQueryResponse,
    ReportuseQueryResponseData,
    ReportuseQueryResponsePagination,
    ReportuseQueryResponseLoading,
    ReportuseQueryResponseColData,
    ReportSelectuseQueryResponse,
    ReportSelectQueryResponseProvider,
    ReportSelectuseQueryResponseData
}
