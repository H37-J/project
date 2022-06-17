import { FC, useMemo } from "react"
import { ID } from "../../core/helpers/models"
import { useListView } from "../../core/ListViewProvider"


type Props = {
    id: ID
}

const UserSelectionCell: FC<Props> = ({ id }) => {
    const { selected, onSelect } = useListView()
    const isSelected = useMemo(() => selected.includes(id), [id, selected])

    return (
        <div className="form-check form-check-sm form-check-custom form-check-solid">
            <input
                className="form-check-input"
                type="checkbox"
                data-h-check={isSelected}
                data-h-check-target="#h_table_users .form-checkinput"
                checked={isSelected}
                onChange={() => onSelect(id)}
            />
        </div>
    )
}

export {UserSelectionCell}