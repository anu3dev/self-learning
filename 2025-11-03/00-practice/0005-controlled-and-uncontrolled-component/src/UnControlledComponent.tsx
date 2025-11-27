import { useRef } from 'react'

function UnControlledComponent() {
  const inputRef = useRef<HTMLInputElement>(null);

  const handleSubmit = () => {
    alert(inputRef.current?.value);
  }

  return (
    <>
      <h4>un-controlled component</h4>
      <div className="form">
        <div className="field">
          <span>your name:</span> 
          <input type="text" ref={inputRef} autoComplete="off" />
        </div>
        <div className="field" style={{marginTop: ".5rem"}}>
          <button onClick={handleSubmit}>submit</button>
        </div>
        <hr />
        <code>since values are not being read from react hook state, it is being
          read directly from DOM so for every update, component won't render
          - this is example of controlled component.
        </code>
      </div>
    </>
  )
}

export default UnControlledComponent
