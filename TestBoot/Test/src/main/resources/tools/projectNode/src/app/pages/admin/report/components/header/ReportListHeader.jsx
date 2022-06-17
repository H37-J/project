import ReportListExcel  from "./ReportListExcel"
import ReportListSearch from "./ReportListSearch"
const ReportListHeader = () => {
    return (
        <div className="card-header boder-0 pt-6">
            <div className="card-title">
                <ReportListSearch />
            </div>
            <div className="card-toolbar">
                <ReportListExcel />
            </div>
        </div>
    )
}

export default ReportListHeader 