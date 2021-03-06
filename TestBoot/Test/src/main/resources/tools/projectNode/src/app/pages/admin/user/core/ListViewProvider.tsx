import { createContext, FC, useContext, useMemo, useState } from "react";
import { calculatedGroupingIsDisabled, calculateIsAllDataSelected, groupingOnSelect, groupingOnSelectAll } from "./helpers/helpers";
import { ID, initialListView, ListViewContextProps } from "./helpers/models";
import { useQueryResponse, useQueryResponseData } from "./QueryResponseProvider";


const ListViewContext = createContext<ListViewContextProps>(initialListView)
const useListView = () => useContext(ListViewContext)

const ListViewProvider: FC = ({ children }) => {
    const [selected, setSelected] = useState<Array<ID>>(initialListView.selected)
    const [itemIdForUpdate, setItemIdForUpdate] = useState<ID>(initialListView.itemIdForUpdate)
    const { isLoading } = useQueryResponse()
    const data = useQueryResponseData()
    const disabled = useMemo(() => calculatedGroupingIsDisabled(isLoading, data), [isLoading, data])
    const isAllSelected = useMemo(() => calculateIsAllDataSelected(data, selected), [data, selected])

    return (
        <ListViewContext.Provider
            value={{
                selected,
                itemIdForUpdate,
                setItemIdForUpdate,
                disabled,
                isAllSelected,
                onSelect: (id: ID) => {
                    groupingOnSelect(id, selected, setSelected)
                },
                onSelectAll: () => {
                    groupingOnSelectAll(isAllSelected, setSelected, data)
                },
                clearSelected: () => {
                    setSelected([])
                },
            }}
        >
            {children}
        </ListViewContext.Provider>
    )
}

export { ListViewProvider, useListView }
