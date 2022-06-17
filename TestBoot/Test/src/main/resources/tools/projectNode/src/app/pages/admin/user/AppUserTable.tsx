import { UserListHeader } from "./components/header/UserListHeader"
import { UserTable } from "./UserTable"
import { ListViewProvider } from "./core/ListViewProvider"
import { QueryRequestProvider } from "./core/QueryRequestProvider"
import { QueryResponseProvider } from "./core/QueryResponseProvider"

const AppUserTable = () => {
    return (
        <QueryRequestProvider>
            <QueryResponseProvider>
                <ListViewProvider>
                    <div className="card">
                        <UserListHeader />
                        <UserTable />
                    </div>
                </ListViewProvider>
            </QueryResponseProvider>
        </QueryRequestProvider>
    )
}

export { AppUserTable }