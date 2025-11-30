import { useState } from 'react'
import useDebounce from './hooks/useDebounce';
import useMousePosition from './hooks/useMouseMove';
import useKeyDown from './hooks/useKeyDown';
import useClick from './hooks/useClick';
import useDblClick from './hooks/useDblClick';

function App() {
  const [searchText, setSearchText] = useState("")

  const getSearchValue = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearchText(e.target.value)
  }

  return (
    <div className='main'>
      <div className="app">
        <h2>Debounce - hooks</h2>
        <hr />
        <input type="text" name="searchText" placeholder='enter value' onChange={getSearchValue}/>
        <code>
          <p>typed value is : {searchText}</p>
          <p>debounced value with 2000 delay is {useDebounce(searchText, 2000)}</p>
        </code>
      </div>
      <div className="app">
        <h2>mouse position - hooks</h2>
        <hr />
        <code>
          <p>x position is : {useMousePosition().x}</p>
          <p>y position is : {useMousePosition().y}</p>
        </code>
      </div>
      <div className="app">
        <h2>key down - hooks</h2>
        <hr />
        <code>
          <p>typed key is : {useKeyDown().key}</p>
          <p>typed code of key is : {useKeyDown().code}</p>
        </code>
      </div>
      <div className="app">
        <h2>click - hooks <span id='click-heading'>| click me</span></h2>
        <hr />
        <code>
          <p>click count is : {useClick()}</p>
          <p>double click count is : {useDblClick()}</p>
        </code>
      </div>
    </div>
  )
}

export default App
