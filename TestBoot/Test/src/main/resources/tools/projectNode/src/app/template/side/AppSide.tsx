import { HSVG } from "../../../_h/helpers/components/HSVG"

const AppSide = () => {
    return (
        <div className='aside aside-dark'>
            {/* 로고시작 */}
            <div id='h-logo' className='aside-logo'>
                <a className='c-white'>H-SITE</a>
                <div id="h-side-toggle" className="btn btn-icon w-auto px-0 btn-active-color-primary aside-toggle">
                    <span className="svg-icon svg-icon-1 rotate-180">
                        <HSVG path='/media/icons/toggle.svg' />
                    </span>
                </div>
            </div>
            {/* 로고 끝 */}
            {/* 메뉴시작 */}
            <div className="my-5">
                <div className="menu-item">
                    <div className="menu-content pt-0 pb-2">
                        <span className="menu-section text-muted text-uppercase fs-8 ls-1">User</span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/dashboard.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            Dashboard
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/profile.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            Profile
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/music.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            Muisc
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/chat.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            chat
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/email.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            Email
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/calendar.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            Calendar
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/file.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            Files
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
                <div className="menu-item">
                    <div className="menu-content pt-8 pb-2">
                        <span className="menu-section text-muted text-uppercase fs-8 ls-1">Admin</span>
                    </div>
                </div>
                <div className="menu-item menu-accordion">
                    <div className="menu-link">
                        <div className="menu-icon">
                            <span className="svg-icon svg-icon-2">
                                <HSVG path="/media/icons/user_management.svg" />
                            </span>
                        </div>
                        <div className="menu-title fw-bolder fs-5">
                            User Managent
                        </div>
                        <span className="menu-arrow"></span>
                    </div>
                </div>
            </div>
            {/* 메뉴 끝 */}
        </div>
    )
}

export { AppSide }