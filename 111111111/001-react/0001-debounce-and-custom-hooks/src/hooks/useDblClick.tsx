import { useEffect, useState } from "react"

const useDblClick = () => {
    const [value, setvalue] = useState(0)

    useEffect(() => {
        const handler = () => {
            setvalue(value + 1);
        }
        
        const tag = document.getElementById('click-heading')

        tag?.addEventListener('dblclick', handler)

        return () => {
            
        tag?.removeEventListener('dblclick', handler)
        }
    },[value])

    return value;
}

export default useDblClick