import { useEffect, useState } from "react"

const useClick = () => {
    const [value, setvalue] = useState(0)

    useEffect(() => {
        const handler = () => {
            setvalue(value + 1);
        }
            
        const tag = document.getElementById('click-heading')
    
        tag?.addEventListener('click', handler)
    
        return () => {     
            tag?.removeEventListener('click', handler)
        }
    },[value])

    return value;
}

export default useClick