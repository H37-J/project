

const ReportCustomRow = ({ row }) => (
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

export default ReportCustomRow