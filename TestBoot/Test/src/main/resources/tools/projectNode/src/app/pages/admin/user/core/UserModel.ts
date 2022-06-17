import { ID, Response } from "./helpers/models"

export type User = {
  name?: string
}

export type UsersQueryResponse = Response<Array<User>>

export const initialUser: User = {
//   avatar: 'avatars/300-6.jpg',
//   position: 'Art Director',
//   role: 'Administrator',
//   name: '',
//   email: '',
}
