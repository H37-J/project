import axios from 'axios'
import React, {useEffect, useState} from 'react'
import SpinnerProject from '../spinner/SpinnerProject'
import InputLabel from '@mui/material/InputLabel'
import MenuItem from '@mui/material/MenuItem'
import FormControl from '@mui/material/FormControl'
import Select from '@mui/material/Select'
import Box from '@mui/material/Box'
import TextField from '@mui/material/TextField'
import ExportCSV from '../csv/ExportCsv'
import Downloads from '../downloads/Downloads'
import ModalOne from '../modal/ModalOne'


const ProjectTable = () => {
  const [posts, setPosts] = useState([])
  const [origin, setOrigin] = useState([])
  const [cols, setCols] = useState([])
  const [select, setSelect] = useState([])
  const [excel, setExcel] = useState([])
  const [title, setTitle] = useState([])
  const [id, setId] = useState(10233)
  const [selected, setSelected] = useState({})
  const [loading, setLoading] = useState(true)

  const POST_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-report/api/api.php?cid=${id}`
  const POST_COL_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-report/api/api_col.php?cid=${id}`
  const POST_TITLE_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-report/api/api_post_title.php?cid=${id}`
  const SELECT_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-report/api/api_select_course.php`

  useEffect(() => {
    let isComponentMounted = true
    setLoading(true)
    const fetchData = async () => {
      const select = await axios.get(SELECT_API)
      const postData = await axios.get(POST_API)
      const titleData = await axios.get(POST_TITLE_API)
      const colData = await axios.get(POST_COL_API)

      if (isComponentMounted) {
        setPosts(postData.data)
        setOrigin(postData.data)
        setCols(colData.data)
        setSelect(select.data)
        setTitle(titleData.data)
        setSelected(id)
        setLoading(false)
        setExcel(getExcel(postData.data))
      }
    }
    fetchData()
    return () => {
      isComponentMounted = false
    }
  }, [id])

  const search = (event) => {
    if (event.target.value !== '') {
      const filteredPost = origin.filter((o) => o.user.includes(event.target.value))
      setPosts(filteredPost)
    } else {
      setPosts(origin)
    }
  }

  const handleChange = (event) => {
    setSelected(event.target.value)
    setId(event.target.value)
  }

  function getExcel(postData) {
    const data = []

    for (let i = 0; i < postData.length; i++) {
      let obj = {}
      for (let j = 0; j < postData[i].lessons.length; j++) {
        obj[postData[i].lessons[j].col] = postData[i].lessons[j].data
      }
      data[i] = obj
    }
    return data
  }

  return (
    <>
      {!loading && (
        <div>
          <div className='d-flex align-items-center'>
            <FormControl className='d-flex col-md-2 ' sx={{m: 1, minWidth: 150}} size='small'>
              <InputLabel id='select-small'>강의를 선택 해주세요</InputLabel>
              <Select
                labelId='select-small'
                id='select-small'
                value={selected}
                label='Selected'
                onChange={handleChange}
              >
                {!loading &&
                  select.map((s) => {
                    return (
                      <MenuItem key={s.id} name={s.post_title} value={s.id}>
                        {s.post_title}
                      </MenuItem>
                    )
                  })}
                {loading && <MenuItem>로딩중..</MenuItem>}
              </Select>
            </FormControl>

            <div className='d-flex col-md-4'>
              <ExportCSV csvData={excel} fileName={title} />
              <ModalOne post = {posts} />
            </div>

            <Box
              className='d-flex col-md-6 justify-content-end align-items-center pe-5'
              component='form'
              sx={{
                '& > :not(style)': {m: 1, width: '30ch'},
              }}
              noValidate
              autoComplete='off'
            >
              <TextField
                onKeyUp={search}
                id='standard-basic'
                label='검색할 학생을 입력 해주세요'
                variant='standard'
              />
            </Box>
          </div>

          <div className='card'>
            <div className='card-body'>
              {posts.length === 0 ? (
                <div>과제가 없습니다</div>
              ) : (
                <>
                  <div className='row'>
                    <div className='col-md-8'>
                      <h4 className='card-title'>과제 레포트</h4>

                      <p className='card-description'></p>
                    </div>
                    <div className='d-flex col-md-4 justify-content-end'></div>
                  </div>
                  <div className='table-responsive'>
                    <table id='htmltable' className='table'>
                      <thead>
                        <tr>
                          <th>아이디</th>
                          {cols.map((col) => {
                            return <th key={col.id}>{col.post_title}</th>
                          })}
                        </tr>
                      </thead>
                      <tbody>
                        {posts.map((post) => {
                          return (
                            <tr key={post.id}>
                              {post.lessons.map((le) => {
                                return <td key={le.id} className='text-center'>{le.data}</td>
                              })}
                            </tr>
                          )
                        })}
                      </tbody>
                    </table>
                  </div>
                </>
              )}
            </div>
          </div>
        </div>
      )}
      {loading && <div>{<SpinnerProject />}</div>}
    </>
  )
}

export {ProjectTable}
