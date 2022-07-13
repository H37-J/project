import React, { createContext, useContext, useMemo, useState } from "react";
import { ReportcalculatedGroupingIsDisabled,ReportcalculateIsAllDataSelected, ReportgroupingOnSelect, ReportgroupingOnSelectAll } from "./helpers/Reporthelpers";
import {ReportinitialListView}  from "./helpers/Reportmodels";
import {ReportuseQueryResponse, ReportuseQueryResponseData } from "./ReportQueryResponseProvider";

const ReportListViewContext = createContext(ReportinitialListView)
const ReportListView = () => useContext(ReportListViewContext)

const ReportListViewProvider = ({ children }) => {
    const [selected, setSelected] = useState(ReportinitialListView.selected)
    const [cid, setCid] = useState()
    const [itemIdForUpdate, setItemIdForUpdate] = useState(ReportinitialListView.itemIdForUpdate)
    const { isLoading } = ReportuseQueryResponse()
    const data = ReportuseQueryResponseData()
    const disabled = useMemo(() => ReportcalculatedGroupingIsDisabled(isLoading, data), [isLoading, data])
    const isAllSelected = useMemo(() => ReportcalculateIsAllDataSelected(data, selected), [data, selected])


    return (
        <ReportListViewContext.Provider
            value={{
                data,
                selected,
                cid,
                itemIdForUpdate,
                setItemIdForUpdate,
                disabled,
                isAllSelected,
                setCid,
                onSelect: (id) => {
                    ReportgroupingOnSelect(id, selected, setSelected)
                },
                onSelectAll: () => {
                    ReportgroupingOnSelectAll(isAllSelected, setSelected, data)
                },
                clearSelected: () => {
                    setSelected([])
                },
                
            }}
        >
            {children}
        </ReportListViewContext.Provider>
    )
}

export {ReportListViewProvider, ReportListView}
