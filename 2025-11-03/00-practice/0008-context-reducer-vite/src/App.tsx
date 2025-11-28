import { useContext } from 'react'
import MyContext from './context/counter/MyContext'

function App() {
  const context = useContext(MyContext);
  
  const {state, dispatch} = context;

  return (
    <>
      <h1>Context + Reducer + Vite</h1>
      <div className="card">
        <div>count value is {state.count}</div>
        <button onClick={() => dispatch({ type: "INCREMENT" })}>
          increase
        </button>
        <button onClick={() => dispatch({ type: "DECREMENT" })}>
          decrease
        </button>
        <button onClick={() => dispatch({ type: "RESET" })}>
          reset
        </button>
      </div>
    </>
  )
}

export default App
