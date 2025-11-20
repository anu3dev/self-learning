### react

####
<details>
<summary> 🟩 Implement a custom hook in React that debounces input value. </summary>

- Debouncing is a technique used to limit how often a function executes, especially in response to fast, repeated events.

```javascript
import { useState, useEffect } from "react";

export function useDebounce(value, delay = 500) {
  const [debouncedValue, setDebouncedValue] = useState(value);

  useEffect(() => {
    const handler = setTimeout(() => {
      setDebouncedValue(value);
    }, delay);

    return () => {
      clearTimeout(handler); // cleanup on value change
    };
  }, [value, delay]);

  return debouncedValue;
}

// using the hook
function SearchInput() {
  const [text, setText] = useState("");
  const debouncedText = useDebounce(text, 500);

  useEffect(() => {
    console.log("API call with:", debouncedText);
  }, [debouncedText]);

  return (
    <input
      value={text}
      onChange={(e) => setText(e.target.value)}
      placeholder="Type something..."
    />
  );
}
```

</details>

####
<details>
<summary> 🟩 controlled and uncontrolled components </summary>

- A controlled component is a form input whose value is fully controlled by React state.
    - React is the single source of truth.
    - Input value updates via onChange.
    - Easier to validate, manipulate, or reset.
    - Good for complex forms.

    ```javascript
    function ControlledInput() {
    const [text, setText] = useState("");

    return (
        <input
        value={text}
        onChange={(e) => setText(e.target.value)}
        />
    );
    }
    ```
- An uncontrolled component stores its own state in the DOM, not in React.
    - Uses ref to access the DOM value.
    - Less React overhead (useful for simple or large forms).
    - Harder to validate in real time.

    ```javascript
    function UncontrolledInput() {
    const inputRef = useRef();

    function handleSubmit() {
        alert(inputRef.current.value); // read from DOM
    }

    return (
        <>
        <input ref={inputRef} />
        <button onClick={handleSubmit}>Submit</button>
        </>
    );
    }
    ```
</details>