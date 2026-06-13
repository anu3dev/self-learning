import { useEffect, useState } from "react"

const useMouseMove = () => {
    const [position, setPosition] = useState({x:0,y:0})

    useEffect(() => {
        const handler = (e: {clientX: number, clientY: number}) => {
            setPosition({x:e.clientX, y: e.clientY});
        }

        document.addEventListener('mousemove', handler)

        return () => {
            document.removeEventListener('mousemove', handler)
        }
    },[])

    return position;
}

export default useMouseMove