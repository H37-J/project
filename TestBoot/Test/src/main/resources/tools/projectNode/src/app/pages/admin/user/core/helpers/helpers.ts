import { createContext, Dispatch, FC, SetStateAction, useEffect, useState } from "react"
import qs from 'qs'
import { ID, QueryResponseContextProps, QueryState } from "./models"

const createResponseContext = <T>(initialState: QueryResponseContextProps<T>) => {
    return createContext(initialState)
}

const isNotEmpty = (obj: unknown) => {
    return obj !== undefined && obj !== null && obj !== ''
}

const stringifyRequestQuery = (state: QueryState) : string => {
    const pagination = qs.stringify(state, {filter: ['page', 'items_per_page'], skipNulls: true})
    const sort = qs.stringify(state, {filter: ['sort', 'order'], skipNulls: true})
    const search = isNotEmpty(state.search) 
    ? qs.stringify(state, {filter: ['search'], skipNulls: true})
    : ''

    return [pagination, sort, search] 
    .filter((f) => f)
    .join("&")
    .toLowerCase()
}

const parseRequestQuery = (query: string): QueryState => {
    const cache: unknown = qs.parse(query)
    return cache as QueryState
}

const calculatedGroupingIsDisabled = <T>(isLoading: boolean, data: Array<T> | undefined ) : boolean => {
    if(isLoading) {
        return true
    }
    return !data || !data.length
}

const calculateIsAllDataSelected = <T>(data: Array<T> | undefined, selected: Array<ID>) : boolean => {
    if (!data) {
        return false
      }
    
      return data.length > 0 && data.length === selected.length
}

const groupingOnSelect = (id: ID, selected: Array<ID>, setSelected: Dispatch<SetStateAction<Array<ID>>>) => {
    if(!id) {
        return 
    }
    
    if(selected.includes(id)) {
        setSelected(selected.filter((itemId) => itemId !== id))
    } else {
        const updateSelected = [...selected]
        updateSelected.push(id)
        setSelected(updateSelected)
    }

}

const groupingOnSelectAll = <T> (isAllSelected: boolean, setSelected: Dispatch<SetStateAction<Array<ID>>>, data?: Array<T & {id?: ID}> ) => {
    if(isAllSelected) {
        setSelected([])
        return
    }
    if(!data || !data.length) {
        return 
    }
    setSelected(data.filter((item) => item.id).map((item) => item.id))
}

const useDebounce = (value: string | undefined, delay: number) => {
    const [debounceValue, setDebounceValue] = useState(value)
    useEffect(() => {
        const handler = setTimeout(() => {
            setDebounceValue(value)
        }, delay)

        return () => {
            clearTimeout(handler)
        }
    }, [value, delay])
    return debounceValue
}

export {
    createResponseContext,
    stringifyRequestQuery,
    parseRequestQuery,
    calculatedGroupingIsDisabled,
    calculateIsAllDataSelected,
    groupingOnSelect,
    groupingOnSelectAll,
    useDebounce
}