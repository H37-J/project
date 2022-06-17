
import {ReportCustomHeader}  from "./ReportCustomHeader"
import ReportDataCell from "./ReportDataCell"
import ReportSelectionCell  from "./ReportSelectionCell"
import ReportSelectionHeader  from "./ReportSelectionHeader"
const ReportColumns = [
    {
        Header: (props) => <ReportSelectionHeader tableProps={props} />,
        id: 'selection',
        Cell: ({ ...props }) => <ReportSelectionCell id={props.data[props.row.index].id} />,
    },
    {
        Header: (props) => <ReportCustomHeader tableProps={props} title='name' className='min-w-125px' />,
        id: 'name',
        Cell: ({ ...props }) => <ReportDataCell name={props.data[props.row.index].name} />,
    }
]



export default ReportColumns
