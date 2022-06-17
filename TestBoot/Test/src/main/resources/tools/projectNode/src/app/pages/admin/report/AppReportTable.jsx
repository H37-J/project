
import React from 'react';
import ReportListHeader from "./components/header/ReportListHeader"
import ReportTable from "./ReportTable"
import { ReportListViewProvider } from './core/ReportListProvider';
import { ReportQueryRequestProvider, ReportSelectQueryRequestProvider } from './core/ReportQueryRequestProviderReport';
import { ReportQueryResponseProvider, ReportSelectQueryResponseProvider } from './core/ReportQueryResponseProvider';


const ReportApp = () => {
    const styles = {
        position: 'static'
    }
    return (
        <div style={styles} className="card">
            <ReportListHeader />
            <ReportTable />
        </div>
    )
}

const AppReportTable = () => {
    return (
        <ReportQueryRequestProvider>
            <ReportSelectQueryRequestProvider>
                <ReportSelectQueryResponseProvider>
                    <ReportQueryResponseProvider>
                        <ReportListViewProvider>
                            <ReportApp />
                        </ReportListViewProvider>
                    </ReportQueryResponseProvider>
                </ReportSelectQueryResponseProvider>
            </ReportSelectQueryRequestProvider>
        </ReportQueryRequestProvider>
    )
}

export default AppReportTable 