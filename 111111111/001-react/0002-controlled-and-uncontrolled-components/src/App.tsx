import { useEffect, useRef, useState } from "react"

function App() {
  // controlled component
  const[formValue, setFormValue] = useState({name: "", city: ""})

  const getFormValue = (e: React.ChangeEvent<HTMLInputElement>) => {
    const {name, value} = e.target
    setFormValue({...formValue, [name] : value})
  }

  // un-controlled component
  const inputRef = useRef<HTMLInputElement>(null);

  useEffect(() => {
    inputRef?.current?.focus()
  },[])

  const getTextFromDom = () => {
    alert(inputRef.current?.value)
  }

  return (
    <>
      <div className="main">
        <div className="app">
          <h2>controlled component</h2>
          <hr />
          <input type="text" name="name" placeholder="your name" onChange={getFormValue} autoComplete="off" />
          <input type="text" name="city" placeholder="your city" onChange={getFormValue} autoComplete="off" />
          <hr />
          <code>value is : {JSON.stringify(formValue)}</code>
        </div>
        <div className="app">
          <h2>un-controlled component</h2>
          <hr />
          <input type="text" ref={inputRef} />
          <button onClick={getTextFromDom}>Get text from DOM</button>
        </div>
      </div>
    </>
  )
}

export default App
