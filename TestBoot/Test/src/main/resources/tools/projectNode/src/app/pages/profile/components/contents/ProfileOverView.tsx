import { HIMG } from "../../../../../_h/helpers/components/HIMG"


const ProfileOverView = () => {
    return (
        <div className="card mb-5 mb-xl-10">
            <div className="card-header border-0">
                <div className="card-title m-0">
                    <h3 className="fw-bolder m-0">회원 상세정보</h3>
                </div>
            </div>
            <form className="form">
                <div className="card-body border-top p-9">
                    <div className="row mb-6">
                        <label className="col-lg-2 col-form-label fw-bold fs-6">프로필 사진</label>
                        <div className="col-lg-10">
                            <div className="image-input image-input-outline" data-image-input="true">
                                <HIMG className="image-input-wrapper w-125px h-125px" path="/media/icons/profile-avatar.svg" />
                                <label className="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                    data-image-input-action="change" data-bs-toggle="tooltip"
                                    title="" data-bs-original-title="Change Avatar">
                                    <i className="bi bi-pencil-fill fs-7"></i>
                                    <input type="file" name="avatar" accept=".png .jpg .jpeg" />
                                    <input type="hidden" name="avatar" value="1" />
                                </label>
                                <span
                                    className="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                    data-image-input-action="remove" data-bs-toggle="tooltip"
                                    title="" data-bs-original-title="Remove avatar">
                                    <i className="bi bi-x fs-2"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div className="row mb-6">
                        <label className="col-lg-2 col-form-label fw-bold fs-6">이름</label>
                        <div className="col-lg-10"><input className="form-control form-control-lg form-control-solid" type="text" name="name" value="호종규" readOnly/></div>
                    </div>
                    <div className="row mb-6">
                        <label className="col-lg-2 col-form-label fw-bold fs-6">성별</label>
                        <div className="col-lg-10"><input className="form-control form-control-lg form-control-solid" type="text" name="name" value="남" readOnly/></div>
                    </div>
                    <div className="row mb-6">
                        <label className="col-lg-2 col-form-label fw-bold fs-6">이메일</label>
                        <div className="col-lg-10"><input className="form-control form-control-lg form-control-solid" type="text" name="name" value="these990712@gmail.com" readOnly/></div>
                    </div>
                </div>
            </form>
        </div>
    )
}

export { ProfileOverView }