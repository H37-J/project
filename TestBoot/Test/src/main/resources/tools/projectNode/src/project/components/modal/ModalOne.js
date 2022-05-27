import React, {useEffect, useState} from 'react'
import Box from '@mui/material/Box'
import Modal from '@mui/material/Modal'
import Button from '@mui/material/Button'
import Typography from '@mui/material/Typography'
import {Checkbox} from '@mui/material'
import CheckBoxOne from '../checkbox/CheckBoxOne'
import {textAlign} from '@mui/system'
import {ButtonContained} from '../button/buttonOne'

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 500,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
  height: 600,
  overflowY: 'scroll',
}

const center = {
  textAlign: 'center',
}

const ModalOne = ({post}) => {
  const [open, setOpen] = useState(false)
  const [posts, setPosts] = useState(post)
  const [origin, setOrigin] = useState(post)
  const [checked, setChecked] = useState([])
  const handleOpen = () => setOpen(true)
  const handleClose = () => setOpen(false)

  const checkHandle = (id) => {
    const filtered = origin.filter((oid) => oid.id != id)
    setPosts(filtered)
  }

  useEffect(() => {}, [posts])

  return (
    <div>
      <Button onClick={handleOpen}>Open modal</Button>
      <Modal
        keepMounted
        open={open}
        onClose={handleClose}
        aria-labelledby='keep-mounted-modal-title'
        aria-describedby='keep-mounted-modal-description'
      >
        <Box className='pb-0' sx={style}>
          <h3 sx={center} className='pt-1 p-md-1 text-center' id='keep-mounted-modal-title'>
            {posts.map((post) => {
              return <span key={post.id}>{post.id}</span>
            })}
          </h3>
          <div className='d-flex flex-wrap ' id='keep-mounted-modal-description' sx={{mt: 2}}>
            {posts.map((post) => {
              return (
                <div key={post.id} className='col-md-6 px-10'>
                  {post.user} <CheckBoxOne checkHandle={() => checkHandle(post.id)} />
                </div>
              )
            })}
          </div>
          <div className='text-center pt-10 pb-10'>
            <button className='btn btn-primary w-100 '>다운로드</button>
          </div>
        </Box>
      </Modal>
    </div>
  )
}

export default ModalOne
