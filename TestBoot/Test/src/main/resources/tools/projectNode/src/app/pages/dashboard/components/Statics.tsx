
import { useEffect } from "react"
import { peityInit } from "../../../../_h/assets/ts/chart/charts"

const Statics = () => {
    useEffect(() => {
        peityInit()
    }, [])

    return (
        <>
            {/* 통계시작 */}
            <div id="statics" className="row gy-5 g-xl-8">
                <div className="col-xl-4">
                    <div className="card card-xl-stretch">
                        <div className="card-body flex flex-col">
                            <div className="flex-grow-1 pb-0">
                                <div className="d-flex flex-stack flex-wrap">
                                    <div className="me-2">
                                        <a href="#"
                                            className="text-dark text-hover-primary fw-bolder fs-3">Visitors
                                            Reports</a>
                                        <div className="text-muted fs-7 fw-bold">
                                            총 방문자수 입니다.
                                        </div>
                                    </div>
                                    <div className="fw-bolder fs-3 c-grey-dark-3">
                                        1,382
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="card-body flex flex-wrap">
                            <span id="peity-chart-one" className="updating-chart-one d-none">4,8,2,7,6,0,9,3,8,2,2,1,8,5</span><svg
                                className="peity" height="30" width="350">
                            </svg>
                        </div>
                    </div>
                </div>
                <div className="col-xl-4">
                    <div className="card card-xl-stretch">
                        <div className="card-body flex flex-col">
                            <div className="flex-grow-1 pb-0">
                                <div className="d-flex flex-stack flex-wrap">
                                    <div className="me-2">
                                        <a href="#"
                                            className="text-dark text-hover-primary fw-bolder fs-3">Users
                                            Reports</a>
                                        <div className="text-muted fs-7 fw-bold">
                                            유저 수 입니다.
                                        </div>
                                    </div>
                                    <div className="fw-bolder fs-3 c-grey-dark-3">
                                        1,382
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="card-body flex flex-wrap">
                            <span id="peity-chart-two" className="updating-chart-two d-none">4,8,2,7,6,0,9,3,8,2,2,1,8,5</span><svg
                                className="peity" height="30" width="350">
                            </svg>
                        </div>
                    </div>
                </div>
                <div className="col-xl-4">
                    <div className="card card-xl-stretch">
                        <div className="card-body flex flex-col">
                            <div className="flex-grow-1 pb-0">
                                <div className="d-flex flex-stack flex-wrap">
                                    <div className="me-2">
                                        <a href="#" className="text-dark text-hover-primary fw-bolder fs-3">Session
                                            Reports</a>
                                        <div className="text-muted fs-7 fw-bold">
                                            현재 로그인 한 세션 수 입니다.
                                        </div>
                                    </div>
                                    <div className="fw-bolder fs-3 c-grey-dark-3">
                                        1,382
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="card-body flex flex-wrap">
                            <span id="peity-chart-three" className="updating-chart-three d-none">4,8,2,7,6,0,9,3,8,2,2,1,8,5</span><svg
                                className="peity w-100" height="30">
                            </svg>
                        </div>
                    </div>
                </div>
            </div>
            {/* 통계끝 */}
        </>
    )
}

export { Statics }