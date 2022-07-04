
import {ReportListView} from '../../core/ReportListProvider'
import React from "react";

const ReportSelectionHeader = ({tableProps}) => {
  const {isAllSelected, onSelectAll} = ReportListView()
  return (
    <th {...tableProps.column.getHeaderProps()} className='w-10px pe-2'>
      <div className='form-check form-check-sm form-check-custom form-check-solid me-3'>
        <input
          className='form-check-input'
          type='checkbox'
          data-h-check={isAllSelected}
          data-h-check-target='#h_table_users .form-check-input'
          checked={isAllSelected}
          onChange={onSelectAll}
        />
      </div>
    </th>
  )
}

export default ReportSelectionHeader
