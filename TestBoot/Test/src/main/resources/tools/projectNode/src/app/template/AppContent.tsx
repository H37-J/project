import { AppUserTable } from "../pages/admin/user/AppUserTable"


const AppContent = () => {
    return (
        <div className="flex flex-col flex-column-fluid content">
            <div className="flex flex-column-fluid">
                <div className="container-xxxl">    
                    <AppUserTable />
                </div>
            </div>
        </div>
    )
}

export { AppContent }