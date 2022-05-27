import axios from 'axios';

export const USER_API =
  'https://video.coursemaker.co.kr/project/node/php/user.php';

export const POST_API = 'https://kua.bigdeo.com/api.php?cid=10233';

export const POST_COL_API = 'https://kua.bigdeo.com/api_col.php?cid=10233';


export function getUser() {
  return axios.get(USER_API);
}

export function getPost() {
  return axios.get(POST_API);
}

export function getCol() {
  return axios.get(POST_COL_API);
}