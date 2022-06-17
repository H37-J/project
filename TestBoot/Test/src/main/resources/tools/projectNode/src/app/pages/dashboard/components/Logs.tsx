import { HSVG } from "../../../../_h/helpers/components/HSVG"

const Logs = () => {
    return (
        <div className='row gy-5 g-xl-8'>
            <div className='col-xl-4'>
                <div className='card card-xl-stretch'>
                    <div className='card-header align-items-center border-0'>
                        <div className='card-title align-items-start flex-col'>
                            <span className='fw-bolder mb-2 text-dark'>Logs</span>
                            <span className='text-muted fw-bold fs-7'>3,421</span>
                        </div>
                        <div className="card-toolbar">
                            <button type="button" className="btn btn-sm btn-icon btn-color-primary btn-active-light-primary"
                                data-h-menu-trigger="click" data-h-menu-placement="bottom-end">
                                <span className="svg-icon svg-icon-2">
                                    <HSVG path="/media/icons/logs.svg" />
                                </span>
                            </button>
                        </div>
                    </div>
                    <div className="card-body pt-5">
                        <div className="timeline-label">
                            <div className="timeline-item">
                                <div className="timeline-label fw-bolder text-grey-800 fs-6">
                                    13:12
                                </div>
                                <div className="timeline-badge">
                                    <i className="fa fa-genderless text-warning fs-1"></i>
                                </div>
                                <div className="fw-moral timeline-content text-muted ps-3">
                                    error occur!
                                </div>
                            </div>
                            <div className="timeline-item">
                                <div className="timeline-label fw-bolder text-grey-800 fs-6">
                                    13:14
                                </div>
                                <div className="timeline-badge">
                                    <i className="fa fa-genderless text-warning fs-1"></i>
                                </div>
                                <div className="timeline-content d-flex">
                                    <span className="fw-bolder text-gray-800 ps-3 text-break">JkV4LiiAE8PmP32qFmuA47s04RiIBlY3Gw1WkTyrf0q70YlfrI8ozvs7nV0</span>
                                </div>
                            </div>
                            <div className="timeline-item mb-9">
                                <div className="timeline-label fw-bolder text-grey-800 fs-6">
                                    13:14
                                </div>
                                <div className="timeline-badge">
                                    <i className="fa fa-genderless text-warning fs-1"></i>
                                </div>
                                <div className="timeline-content d-flex">
                                    <span className="fw-bolder text-gray-800 ps-3 text-break">Completed!Completed!Completed!Completed!Completed!</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export { Logs }
