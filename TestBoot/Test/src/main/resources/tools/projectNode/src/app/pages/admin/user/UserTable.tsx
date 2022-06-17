import { useEffect, useMemo } from "react"
import { ColumnInstance, Row, useTable } from "react-table"
import { HCardBody } from "../../../components/card/HCardBody"
import { useQueryResponseData, useQueryResponseLoading } from "./core/QueryResponseProvider"
import { User } from "./core/UserModel"

import { CustomHeaderColumn } from "./components/table/CustomHeaderColumn"
import { CustomRow } from "./components/table/CustomRow"
import { usersColumns } from "./components/table/columns"
import { UsersListLoading } from "./components/loading/UserListLoading"
import { UserListPagination } from "./components/pagination/UserListPagination"

const UserTable = () => {
    const users = useQueryResponseData()
    const isLoading = useQueryResponseLoading()
    const data = useMemo(() => users, [users])
    const columns = useMemo(() => usersColumns, [])
    const { getTableProps, getTableBodyProps, headers, rows, prepareRow } = useTable({
        columns,
        data,
    })

    return (
        <HCardBody classname="py-4">
            <div className="table-responsive">
                <table id="h_table_users" className="table align-middel table-row-dashed fs-6 gy-5" {...getTableProps()}>
                    <thead>
                        <tr className='text-start text-muted fw-bolder fs-7 text-uppercase gs-0'>
                            {headers.map((column: ColumnInstance<User>) => (
                                <CustomHeaderColumn key={column.id} column={column} />
                            ))}
                        </tr>
                    </thead>
                    <tbody className="text-gray-600 fw-bold" {...getTableBodyProps()}>
                        {rows.length > 0 ? (
                            rows.map((row: Row<User>, i) => {
                                prepareRow(row)
                                return <CustomRow row={row} key={`row-${i}-${row.id}`} />
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
            <UserListPagination />
            {isLoading && <UsersListLoading />}
        </HCardBody>
    )
}

export { UserTable }

