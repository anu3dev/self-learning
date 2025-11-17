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
<summary> 🟩  </summary>



</details>