import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  userName: 'Guest',
}

export const userNameSlice = createSlice({
  name: 'updateUserName',
  initialState,
  reducers: {
    update: (state, action) => {
      state.userName = action.payload
    },
    reset: (state, action) => {
        console.log(state, action)
      state.userName = initialState.userName
    },
  },
})

// Action creators are generated for each case reducer function
export const { update, reset } = userNameSlice.actions

export default userNameSlice.reducer