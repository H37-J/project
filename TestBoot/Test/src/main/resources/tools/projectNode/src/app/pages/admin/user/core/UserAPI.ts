import axios, { AxiosResponse } from "axios"
import { UsersQueryResponse } from "./UserModel"


const API_URL = 'test'
const USER_URL = 'https://video.coursemaker.co.kr/custom/php/test.php'

const getUsers = (query: string): Promise<UsersQueryResponse> => {
    return axios
    .get(`${USER_URL}?${query}`)
    .then((response: AxiosResponse<UsersQueryResponse>) => response.data)
}

export {getUsers}