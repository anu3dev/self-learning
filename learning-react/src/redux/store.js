import { configureStore } from '@reduxjs/toolkit'
import updateUserName from '../redux/feature/updateUser'

export const store = configureStore({
  reducer: {
    user: updateUserName,
  },
})