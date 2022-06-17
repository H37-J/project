import { HSVG } from "../../../../../../_h/helpers/components/HSVG"
import { UserListSearch } from "./UserLisetSearch"
import { UserListExcel } from "./UserListExcel"

const UserListHeader = () => {
    return (
        <div className="card-header boder-0 pt-6">
            <div className="card-title">
                <UserListSearch />
            </div>
            <div className="card-toolbar">
                <UserListExcel />
            </div>
        </div>
    )
}

export { UserListHeader }