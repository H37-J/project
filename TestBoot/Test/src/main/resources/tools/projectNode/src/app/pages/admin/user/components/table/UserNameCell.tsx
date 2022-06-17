import {FC} from 'react'

type Props = {
  name?: string
}

const UserNameCell: FC<Props> = ({name}) => (
  <div>{name}</div>
)

export {UserNameCell}
