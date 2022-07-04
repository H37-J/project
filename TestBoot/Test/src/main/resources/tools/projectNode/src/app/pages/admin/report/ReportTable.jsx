import  React, { useMemo } from "react"
import { useTable } from "react-table"
import { ReportuseQueryResponseColData, ReportuseQueryResponseData, ReportuseQueryResponseLoading } from "./core/ReportQueryResponseProvider"

import  ReportListLoading  from "./components/loading/ReportListLoading"
import  ReportCustomRow  from "./components/table/ReportCustomRow"
import  ReportCardBody  from "./components/card/ReportCardBody"
import { ReportCustomHeaderColumn } from "./components/table/ReportCustomHeaderColumn"

const ReportTable = () => {
    const reports = ReportuseQueryResponseData()
    const isLoading = ReportuseQueryResponseLoading()
    const data = useMemo(() => reports, [reports])
    const ReportColumn = ReportuseQueryResponseColData()
    const columns = useMemo(() => ReportColumn, [ReportColumn])

    const { getTableProps, getTableBodyProps, headers, rows, prepareRow } = useTable({
        columns,
        data,
        autoResetHiddenColumns: false,    //  <-- stops the rerendering 🥳
        autoResetSortBy: false, //  <-- stops the rerendering 🥳
    })

    return (
        <ReportCardBody classname="py-4">
            <div className="table-responsive">
                <table id="h_table_users" className="table align-middel table-row-dashed fs-6 gy-5" {...getTableProps()}>
                    <thead>
                        <tr className='text-start text-muted fw-bolder fs-7 text-uppercase gs-0'>
                            {headers.map((column) => (
                                <ReportCustomHeaderColumn key={column.id} column={column} />
                            ))}
                        </tr>
                    </thead>
                    <tbody className="text-gray-600 fw-bold" {...getTableBodyProps()}>
                        {rows.length  > 0 && rows[0].original.id !== '' ? (
                            rows.map((row, i) => {
                                prepareRow(row)
                                return <ReportCustomRow row={row} key={`row-${i}-${row.id}`} />
                            })
                        ) : (
                            <tr>
                                <td colSpan={2}>
                                    <div className='d-flex text-center w-100 align-content-center justify-content-center'>
                                        데이터가 존재하지 않습니다
                                    </div>
                                </td>
                            </tr>
                        )
                        }
                    </tbody>
                </table>
            </div>
            {isLoading && <ReportListLoading />}
        </ReportCardBody>
    )
}

export default ReportTable

