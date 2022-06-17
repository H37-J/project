import { HSVG } from "../../../../_h/helpers/components/HSVG"


const ProfileHeader = () => {
    return (
        <div className="card mb-5 mb-xl-10">
            <div className="card-body pt-9 pb-0">
                <div className="flex flex-wrap flex-sm-nowrap mb-3">
                    <div className="me-7 mb-4">
                        <div className="symbol symbol-100px symbol-lg-160px symbol-fixed position-relative cursor-pointer">
                            <img src="https://preview.keenthemes.com/metronic8/demo1/assets/media/avatars/300-1.jpg" alt="user" />
                            <div className="position-absolute translate-middle top-100 bottom-0 start-100 mb-6 bg-sucess rounded-circle border border-4 border-white h-20px w-20px"></div>
                        </div>
                    </div>
                    <div className="flex-grow-1">
                        <div className="flex justify-content-between align-items-start flex-wrap mb-2">
                            <div className="flex-col">
                                <div className="flex align-items-center mb-2">
                                    <span className="text-gray-900 text-hover-primary fs-2 fw-bolder me-3">호종규</span>
                                </div>
                                <div className="flex flex-wrap fw-bold fs-6 mb-4 pe-2">
                                    <div className="flex align-items-center text-gray-400 me-5 mb-2">
                                        <span className="svg-icon svg-icon-4 me-1">
                                            <HSVG path="/media/icons/profile-man.svg" />
                                        </span>
                                        남성
                                    </div>
                                    <div className="flex align-items-center text-gray-400 me-5 mb-2">
                                        <span className="svg-icon svg-icon-4 me-1">
                                            <HSVG path="/media/icons/profile-email.svg" />
                                        </span>
                                        these990712@gmail.com
                                    </div>
                                </div>
                            </div>
                            <div className="flex">
                                <a id="follow_button" className="btn btn-sm me-2 btn-light" href="#">팔로우</a>
                                <a className="btn btn-sm btn-primary me-2" href="#">탈퇴하기</a>
                                <button className="btn btn-sm btn-icon btn-bg btn-bg-light btn-active-color-primary"
                                    data-menu-trigger="click" data-meun-placement="bottom-end"><i className="bi bi-three-dots"></i></button>
                            </div>
                        </div>
                        <div className="flex flex-wrap flex-stack">
                            <div className="flex flex-col flex-grow-1 pe-8">
                                <div className="flex align-items-center">
                                    <div className="fs-2 fw-bolder border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                                        <div id="view_count">130</div>
                                        <div className="fw-bold fs-6 text-gray-400">Most View Page</div>
                                    </div>
                                    <div className="fs-2 fw-bolder border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                                        <div id="browser">Chrome</div>
                                        <div className="fw-bold fs-6 text-gray-400">Browser</div>
                                    </div>
                                    <div className="fs-2 fw-bolder border border-gray-300 border-dashed rounded min-w-125px py-3 px-4 me-6 mb-3">
                                        <div id="ip_address">132.121.334.121</div>
                                        <div className="fw-bold fs-6 text-gray-400">IP Address</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <ul className="nav nav-stretch nav-line-tabs nav-line-tabs-2x border-transparent fs-5 fw-bolder">
                    <li className="nav-item mt-2">
                        <a className="nav-link text-active-primary ms-0 me-10 py-5 active" href="#">프로필</a>
                    </li>
                    <li className="nav-item mt-2">
                        <a className="nav-link text-active-primary ms-0 me-10 py-5" href="#">API</a>
                    </li>
                    <li className="nav-item mt-2">
                        <a className="nav-link text-active-primary ms-0 me-10 py-5" href="#">Logs</a>
                    </li>
                    <li className="nav-item mt-2">
                        <a className="nav-link text-active-primary ms-0 me-10 py-5" href="#">설정</a>
                    </li>
                </ul>

            </div>
        </div>
    )
}

export { ProfileHeader }