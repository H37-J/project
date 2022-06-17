import axios from "axios"

const REPORT_URL = 'https://cybercampus.kua.ac.kr/wp-content/plugins/project-report/api/api.php'
const SELECT_LIST_URL = 'https://cybercampus.kua.ac.kr/wp-content/plugins/project-report/api/api_select_course.php'

const getReports = (query) => {
    return axios
    .get(`${REPORT_URL}?=${query}`)
    .then((response) => response.data)
}

const getSelectList = (query) => {
    return axios
    .get(`${SELECT_LIST_URL}?=${query}`)
    .then((response) => response.data)
}



export {getReports, getSelectList}