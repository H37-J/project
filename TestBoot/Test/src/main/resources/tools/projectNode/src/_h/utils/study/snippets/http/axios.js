const { default: axios } = require("axios")

const arr = []
const result = axios.get('https://online.seoulwomen.or.kr/wp-content/plugins/essays/api/api_select_course.php')
result.then(res => {
    arr.push(res.data)

})

console.log(arr)

// axios.post('https://www.naver.com', {
//     user: 'user',
//     pass: 'star8903'
// }).then((res) => console.log(res))

// axios.post('https://')