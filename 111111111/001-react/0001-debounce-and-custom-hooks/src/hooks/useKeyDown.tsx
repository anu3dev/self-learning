import { useEffect, useState } from "react";

const useKeyDown = () => {
    const [keyDetails, setKeyDetails] = useState({key: '', code: ''})

    useEffect(() => {
        const handler = (e: {key: string, code: string}) => {
            setKeyDetails({key: e.key, code: e.code});
        }

        document.addEventListener("keydown", handler)

        return () => {
            document.removeEventListener("keydown", handler)
        }
    }, [])

    return keyDetails
}

export default useKeyDown;