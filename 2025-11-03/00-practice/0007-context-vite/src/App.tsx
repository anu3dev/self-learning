import { useContext } from "react"
import GlobalContext from "./context/GlobalContext"

const  App = () => {
  const context = useContext(GlobalContext)
  const {theme, toggleTheme} = context.themeContext;
  const {user, updateUser} = context.userContext

  return (
    <>
      <h1>Context + Vite</h1>
      <div className="app">
        <div>theme is {theme}</div>
        <div><button onClick={toggleTheme}>toggle theme</button></div>
        <hr />
        <div>user is {user}</div>
        <div><button onClick={() => updateUser("nitish")}>update user</button></div>
      </div>
    </>
  )
}

export default App
