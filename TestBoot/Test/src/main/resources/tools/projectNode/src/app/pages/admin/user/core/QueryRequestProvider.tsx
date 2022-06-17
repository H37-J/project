import { createContext, FC, useContext, useState } from "react";
import { initialQueryRequest, QueryRequestContextProps, QueryState } from "./helpers/models";

const QueryRequestContext = createContext<QueryRequestContextProps>(initialQueryRequest)
const useQueryRequest = () => useContext(QueryRequestContext)

const QueryRequestProvider: FC = ({children}) => {
    const [state, setState] = useState<QueryState>(initialQueryRequest.state)

    const updateState = (updates: Partial<QueryState>) => {
        const updatedState = {...state, ...updates} as QueryState
        setState(updatedState)
    }

    return (
        <QueryRequestContext.Provider value={{state, updateState}}>
            {children}
        </QueryRequestContext.Provider>
    )
}

export {QueryRequestProvider, useQueryRequest}