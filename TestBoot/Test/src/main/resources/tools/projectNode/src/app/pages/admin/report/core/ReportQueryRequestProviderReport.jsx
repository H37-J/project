import React, { createContext, useContext, useState } from "react";
import { ReportinitialQueryRequest } from "./helpers/Reportmodels";


const ReportQueryRequestContext = createContext(ReportinitialQueryRequest)
const ReportuseQueryRequest = () => useContext(ReportQueryRequestContext)

const ReportQueryRequestProvider = ({ children }) => {
    const [state, setState] = useState(ReportinitialQueryRequest.state)

    const updateState = (updates) => {
        const updatedState = { ...state, ...updates }
        setState(updatedState)
    }

    return (
        <ReportQueryRequestContext.Provider value={{ state, updateState }}>
            {children}
        </ReportQueryRequestContext.Provider>
    )
}

const ReportSelectQueryRequestContext = createContext('')
const ReportSelectuseQueryRequest = () => useContext(ReportSelectQueryRequestContext)

const ReportSelectQueryRequestProvider = ({ children }) => {
    const [selectState, setSelectState] = useState(10233)

    const updateSelectState = (selectUpdates) => {
        setSelectState(selectUpdates)
    }

    return (
        <ReportSelectQueryRequestContext.Provider value={{ selectState, updateSelectState }}>
            {children}
        </ReportSelectQueryRequestContext.Provider>
    )
}

export { ReportQueryRequestProvider, ReportuseQueryRequest, ReportSelectQueryRequestProvider, ReportSelectuseQueryRequest }