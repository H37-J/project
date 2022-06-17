import { FC } from "react"
import { Row } from "react-table"
import { User } from "../../core/UserModel"

type Props = {
    row: Row<User>
}

const CustomRow: FC<Props> = ({ row }) => (
    <tr {...row.getRowProps()}>
        {row.cells.map((cell) => {
            return (
                <td
                    {...cell.getCellProps()}
                >
                    {cell.render('Cell')}
                </td>
            )
        })}
    </tr>
)

export {CustomRow}