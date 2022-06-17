import { HSVG } from "../../../../../../_h/helpers/components/HSVG"

const UserListExcel = () => {
    return (
        <div className="flex justify-content-end">
            <button type="button" className="btn btn-light-primary me-3" data-bs-toggle="modal" data-bs-target="#h_modal_export_users">
                <span className="svg-icon svg-icon-2">
                    <HSVG path="/media/icons/button-excel.svg" />
                </span>
                Excel Export
            </button>
        </div>
    )
}

export { UserListExcel }