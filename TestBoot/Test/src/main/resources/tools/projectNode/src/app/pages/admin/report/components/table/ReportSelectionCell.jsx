import React, { useMemo } from "react"
import {ReportListView}  from "../../core/ReportListProvider"



const ReportSelectionCell = ({ id }) => {
    const { selected, onSelect } = ReportListView()
    const isSelected = useMemo(() => selected.includes(id), [id, selected])
    const styles = {
        background: '' 
    }
    return (
        <div className="form-check form-check-sm form-check-custom form-check-solid">
            <input style={styles}
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

export default ReportSelectionCell