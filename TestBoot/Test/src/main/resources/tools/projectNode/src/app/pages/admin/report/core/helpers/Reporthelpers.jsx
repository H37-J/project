import { createContext, useEffect, useState } from "react"
import qs from 'qs'

const ReportcreateResponseContext = (ReportinitialState) => {
    return createContext(ReportinitialState)
}

const ReportisNotEmpty = (obj) => {
    return obj !== undefined && obj !== null && obj !== ''
}

const ReportstringifyRequestQuery = (state) => {
    const pagination = qs.stringify(state, { filter: ['page', 'items_per_page'], skipNulls: true })
    const sort = qs.stringify(state, { filter: ['sort', 'order'], skipNulls: true })
    const search = ReportisNotEmpty(state.search)
        ? qs.stringify(state, { filter: ['search'], skipNulls: true })
        : ''
    const cid = ReportisNotEmpty(state.cid)
        ? qs.stringify(state, { filter: ['cid'], skipNulls: true })
        : ''

    return [pagination, sort, search, cid]
        .filter((f) => f)
        .join("&")
        .toLowerCase()
}

const ReportparseRequestQuery = (query) => {
    const cache = qs.parse(query)
    return cache
}

const ReportcalculatedGroupingIsDisabled = (isLoading, data) => {
    if (isLoading) {
        return true
    }
    return !data || !data.length
}

const ReportcalculateIsAllDataSelected = (data, selected) => {
    if (!data) {
        return false
    }

    return data.length > 0 && data.length === selected.length
}

const ReportgroupingOnSelect = (id, selected, setSelected) => {
    if (!id) {
        return
    }

    if (selected.includes(id)) {
        setSelected(selected.filter((itemId) => itemId !== id))
    } else {
        const updateSelected = [...selected]
        updateSelected.push(id)
        setSelected(updateSelected)
    }

}

const ReportgroupingOnSelectAll = (isAllSelected, setSelected, data) => {
    if (isAllSelected) {
        setSelected([])
        return
    }
    if (!data || !data.length) {
        return
    }
    setSelected(data.filter((item) => item.id).map((item) => item.id))
}

const ReportgroupingOnSelectAllDisable = (setSelected) => {
    setSelected([])
}


const ReportuseDebounce = (value, delay) => {
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
    ReportcreateResponseContext,
    ReportstringifyRequestQuery,
    ReportparseRequestQuery,
    ReportcalculatedGroupingIsDisabled,
    ReportcalculateIsAllDataSelected,
    ReportgroupingOnSelect,
    ReportgroupingOnSelectAll,
    ReportuseDebounce,
    ReportgroupingOnSelectAllDisable
}