import * as React from 'react'
import Stack from '@mui/material/Stack'
import Button from '@mui/material/Button'

const ButtonText = ({text}) => {
  return <Button variant='text'>{text}</Button>
}

const ButtonContained = ({text}) => {
  return <Button variant='contained'>{text}</Button>
}
const ButtonOutlined = () => {
  return <Button variant='outlined'>{text}</Button>
}

export {ButtonText, ButtonContained, ButtonOutlined}
