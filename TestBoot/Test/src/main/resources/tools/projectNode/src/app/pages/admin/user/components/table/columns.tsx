import { Column } from 'react-table'
import { UserCustomHeader } from './UserCustomHeader'
import { User } from '../../core/UserModel'
import { UserNameCell } from './UserNameCell'
import { UserSelectionHeader } from './UserSelectionHeader'
import { UserSelectionCell } from './UserSelectionCell'


const usersColumns: ReadonlyArray<Column<User>> = [
    {
        Header: (props) => <UserSelectionHeader tableProps={props} />,
        id: 'selection',
        Cell: ({ ...props }) => <UserSelectionCell id={props.data[props.row.index].id} />,
    },
    {
        Header: (props) => <UserCustomHeader tableProps={props} title='Name' className='min-w-125px' />,
        id: 'name',
        Cell: ({ ...props }) => <UserNameCell name={props.data[props.row.index].name} />,
    },

]

export { usersColumns }
