import { useState } from 'react';
import * as Yup from 'yup';
import { useAuth } from '../core/Auth';
import { useFormik } from 'formik';
import { getUserByToken, login } from '../core/_requests';
import { Link } from 'react-router-dom';
import clsx from 'clsx';

const loginSchema = Yup.object().shape({
  login: Yup.string()
    .min(3, '최소 3글자 이상입니다')
    .max(50, '최대 50글자 이상입니다')
    .required('필수 입력 사항입니다'),
  //.email('잘못된 이메일 형식입니다')

  password: Yup.string()
    .min(3, '최소 3글자 이상입니다')
    .max(50, '최대 50글자 이상입니다')
    .required('필수 입력 사항입니다'),
});

const initialValues = {
  login: 'these990712',
  password: 'star8903!@',
};

export function Login() {
  const [loading, setLoading] = useState(false);
  const { saveAuth, setCurrentUser } = useAuth();

  const formik = useFormik({
    initialValues,
    validationSchema: loginSchema,
    onSubmit: async (values, { setStatus, setSubmitting }) => {
      setLoading(true);
      try {
        const { data: auth } = await login(values.login, values.password);
        saveAuth(auth);
        const { data: user } = await getUserByToken(auth.api_token);
        setCurrentUser(user);
      } catch (error) {
        console.error(error);
        saveAuth(undefined);
        setStatus('The login detail is incorrect');
      }
    },
  });

  return (
    <form
      className="form w-100"
      onSubmit={formik.handleSubmit}
      noValidate
      id="h_login-signin_form"
    >
      <div className="text-center mb-10">
        <h1 className="text-dark mb-3">회원가입</h1>
        <div className="text-gray-400 fw-bold fs-4">
          처음 오셨나요?{' '}
          <Link to="/auth/registration" className="link-primary fw-bolder">
            회원가입하기
          </Link>
        </div>
      </div>

      {formik.status ? (
        <div className="mb-lg-15 alert alert-danger">
          <div className="alert-text font-weight-bold">{formik.status}</div>
        </div>
      ) : (
        <div className="mb-10 bg-light-info p-8 rounded">
          <div className="text-info">계정이 없다면 새로 생성 해주세요.</div>
        </div>
      )}

      <div className="fv-row mb-10">
        <label className="form-label fs-6 fw-bolder text-dark">아이디</label>
        <input
          placeholder="이메일"
          {...formik.getFieldProps('login')}
          className={clsx(
            'form-control form-control-lg form-control-solid',
            { 'is-invalid': formik.touched.login && formik.errors.login },
            { 'is-valid': formik.touched.login && !formik.errors.login },
          )}
          type="text"
          name="login"
          autoComplete="off"
        />
        {formik.touched.login && formik.errors.login && (
          <div className="fv-plugins-message-container">
            <span role="alert">{formik.errors.login}</span>
          </div>
        )}
      </div>

      <div className='fv-row mb-10'>
        <div className='d-flex justify-content-between mt-n5'>
          <div className='d-flex flex-stack mb-2'>
            <label className='form-label fw-bolder text-dark fs-6 mb-0'>비밀번호</label>
            <Link
              to='/auth/forgot-password'
              className='link-primary fs-6 fw-bolder'
              style={{marginLeft: '5px'}}
            >
              비밀번호를 잊으셨나요?
            </Link>
          </div>
        </div>
        <input
          type='password'
          autoComplete='off'
          {...formik.getFieldProps('password')}
          className={clsx(
            'form-control form-control-lg form-control-solid',
            {
              'is-invalid': formik.touched.password && formik.errors.password,
            },
            {
              'is-valid': formik.touched.password && !formik.errors.password,
            }
          )}
        />
        {formik.touched.password && formik.errors.password && (
          <div className='fv-plugins-message-container'>
            <div className='fv-help-block'>
              <span role='alert'>{formik.errors.password}</span>
            </div>
          </div>
        )}
      </div>

      <div className='text-center'>
        <button
          type='submit'
          id='h_sign_in_submit'
          className='btn btn-lg btn-primary w-100 mb-5'
          disabled={formik.isSubmitting || !formik.isValid}
        >
          {!loading && <span className='indicator-label'>로그인</span>}
          {loading && (
            <span className='indicator-progress' style={{display: 'block'}}>
              잠시만 기다려주세요...
              <span className='spinner-border spinner-border-sm align-middle ms-2'></span>
            </span>
          )}
        </button>

  
      </div>
    </form>
  );
}
