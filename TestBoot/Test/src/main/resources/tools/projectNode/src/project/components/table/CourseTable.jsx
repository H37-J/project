import axios from 'axios'
import React, {useEffect, useState} from 'react'

import InputLabel from '@mui/material/InputLabel'
import MenuItem from '@mui/material/MenuItem'
import FormControl from '@mui/material/FormControl'
import Select from '@mui/material/Select'
import Box from '@mui/material/Box'
import TextField from '@mui/material/TextField'
import ExportCSV from '../csv/ExportCsv'


const CourseTable = () => {
  const [posts, setPosts] = useState([])
  const [origin, setOrigin] = useState([])
  const [cols, setCols] = useState([])
  const [select, setSelect] = useState([])
  const [excel, setExcel] = useState([])
  const [title, setTitle] = useState([])
  const [id, setId] = useState()
  const [selected, setSelected] = useState({})
  const [loading, setLoading] = useState(true)
  const [re, setRe] = useState(false)

  const POST_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-course/api/api_data.php?id=${id}`
  const POST_COL_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-course/api/api_col.php?id=${id}`
  const SELECT_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-course/api/api_select.php?`
  const POST_TITLE_API = `https://cybercampus.kua.ac.kr/wp-content/plugins/project-course/api/api_title.php?id=${id}`

  useEffect(() => {
    let isComponentMounted = true
    setLoading(true)
    const fetchData = async () => {
      const select = await axios.get(SELECT_API)
      const postData = await axios.get(POST_API)
      const colData = await axios.get(POST_COL_API)
      const titleData = await axios.get(POST_TITLE_API)
      if (isComponentMounted) {
        postData.data.sort(function (a, b) {
          if (a.name > b.name) {
            return 1;
          }
          if (a.name < b.name) {
            return -1;
          }
          return 0;
        });
        setPosts(postData.data)
        setOrigin(postData.data)
        setCols(colData.data)
        setSelect(select.data)
        setSelected(id)
        setLoading(false)
        setTitle(titleData.data)
        setExcel(getExcel(postData.data))

        
      }
    }
    fetchData()
    return () => {
      isComponentMounted = false
    }
  }, [re, id])

  const search = (event) => {
    if (event.target.value !== '') {
      const filteredPost = origin.filter((o) => o.name.includes(event.target.value))
      setPosts(filteredPost)
    } else {
      setPosts(origin)
    }
  }

  const handleChange = (event) => {
    setSelected(event.target.value)
    setId(event.target.value)
  }

  const getExcel = (postData) => {
    const data = []

    for (let i = 0; i < postData.length; i++) {
      let obj = {}
      for (let j = 0; j < postData[i].data.length; j++) {
        obj[postData[i].key[j]] = postData[i].data[j].data
      }
      data[i] = obj
    }
    return data
  }



  const over = (event) => {
    event.target.style.border = '5px solid #477cd'
    event.target.style.backgroundColor = '#009ef7'
    event.target.style.fontWeight = 'bold'
    event.target.style.color = '#fff'
    event.target.style.boxSizing = 'border-box'
  }

  const leave = (event) => {
    event.target.style.border = ''
    event.target.style.backgroundColor = ''
    event.target.style.fontWeight = ''
    event.target.style.color = ''
    event.target.style.boxSizing = ''
  }

  const tbody = (
    <>
      <div className='row'>
        <div className='col-md-8'>
          <h4 className='card-title'>출석부</h4>
          <p className='card-description'></p>
        </div>
        <div className='d-flex col-md-4 justify-content-end'></div>
      </div>
      <div className='table-responsive'>
        <table id='htmltable' className='table'>
          <thead>
            <tr>
              {cols.map((col) => {
                return <th key={col}>{col}</th>
              })}
            </tr>
          </thead>
          <tbody>
            {posts.map((post) => {
              return (
                <tr>
                  {post.data.map((obj) => {
                    return (
                      <td
                        onMouseLeave={(e) => leave(e)}
                        onMouseOver={(e) => over(e)}
                       
                      >
                        {obj.data}
                      </td>
                    )
                  })}
                </tr>
              )
            })}
          </tbody>
        </table>
      </div>
    </>
  )

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
                      <MenuItem key={s.ID} name={s.post_title} value={s.ID}>
                        {s.post_title}
                      </MenuItem>
                    )
                  })}
                {loading && <MenuItem>로딩중..</MenuItem>}
              </Select>
            </FormControl>

            <div className='d-flex col-md-4'>
              {posts.length !== 0 && <ExportCSV csvData={excel} fileName={title} />}
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
              {!selected ? <></> : posts.length === 0 ? <div>데이터가 없습니다</div> : tbody}
            </div>
          </div>
        </div>
      )}

    </>
  )
}

export {CourseTable}
