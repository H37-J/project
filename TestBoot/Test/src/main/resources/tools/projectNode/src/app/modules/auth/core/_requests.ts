import axios from 'axios';
import { AuthModel, UserModel } from './_models';

const API_URL = 'https://preview.keenthemes.com/metronic8/laravel/api';

export const GET_USER_BY_ACCESSTOKEN_URL = `${API_URL}/verify_token`;
export const LOGIN_URL = `${API_URL}/login`;
export const REGISTER_URL = `${API_URL}/register`;
export const REQUEST_PASSWORD_URL = `${API_URL}/forgot_password`;

export function login(login: string, password: string) {
  return axios.post<AuthModel>(LOGIN_URL, {
    login,
    password,
  });
}

export function regitser(
  login: string,
  email: string,
  name: string,
  password: string,
  password_confirmation: string,
) {
  return axios.post(REGISTER_URL, {
    login,
    email,
    name,
    password,
    password_confirmation,
  });
}

export function requestPassword(email: string) {
  return axios.post<{ result: boolean }>(REGISTER_URL, {
    email,
  });
}
export function getUserByToken(token: string) {
  return axios.post<UserModel>(GET_USER_BY_ACCESSTOKEN_URL, {
    api_token: token,
  });
}
