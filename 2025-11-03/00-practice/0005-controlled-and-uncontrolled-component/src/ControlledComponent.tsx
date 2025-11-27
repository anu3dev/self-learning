import { useState, useRef, type ChangeEvent, useEffect } from 'react'

function ControlledComponent() {
  const currentRef = useRef<HTMLInputElement>(null);

  const [formValue, setFormValue] = useState([
    {name: "name", getValue: "", isError: false},
    {name: "city", getValue: "", isError: false},
    {name: "mobile", getValue: "", isError: false}
  ])

  useEffect(() => {
    currentRef.current?.focus();
  },[])

  const handleFormValue = (e: ChangeEvent<HTMLInputElement>) => {
    const {name, value} = e.target;

    formValue?.map((item) => {
      if(item?.name === name){
        item.getValue = value
        item.isError = false
      }
    })

    setFormValue([...formValue])
  }

  const checkError = () => {
    formValue?.map((item) => {
      if(!item?.getValue){
        item.isError = true
      }
    })

    setFormValue([...formValue])
  }

  return (
    <>
      <h4>controlled component</h4>
      <div className="form">
        {formValue?.length && formValue?.map((item, index) => {
          return(
            <div className="field" key={index}>
              <span>your {item?.name} : <span style={{color: "red"}}>{item?.isError ? "fix the error" : ""}</span></span> 
              <input type="text" ref={index === 0 ? currentRef : null} name={item?.name} value={item?.getValue} onChange={handleFormValue} autoComplete="off" className={item?.isError ? "input-error" : ""} />
            </div>
          )
        })}
        <div className="field" style={{marginTop: ".5rem"}}>
          <button onClick={checkError}>submit</button>
        </div>
        <hr />
        <code>since values are being read from react hook state and for every 
          value update, component will be rendered - this is example of 
          controlled component.
        </code>
      </div>
    </>
  )
}

export default ControlledComponent
