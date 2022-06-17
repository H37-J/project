import { HSVG } from "../../../_h/helpers/components/HSVG"

const AppToolBar = () => {
    return (
        <div className="toolbar">
            <div className="container-fluid flex align-items-center">
                <HSVG path="/media/icons/dashboard.svg" />
                <span className="h-20px border-gray-300 border-start mx-4"></span>
                <h1 className="flex align-items-center fw-bolder fs-3 text-dark my-1">
                    DashBoard </h1>
            </div>
        </div>
    )
}

export { AppToolBar }