import { useContext, useState, type ReactNode } from "react";
import GlobalContext from "./GlobalContext";

const UserContext = ({children}: {children: ReactNode}) => {
    const globalContext = useContext(GlobalContext);

    const [user, setUser] = useState("anurag");

    const updateUser = (name?: string):void => {
        if (name !== undefined) {
            setUser(name);
        }
    }

    return (
        <GlobalContext.Provider value={{...globalContext, userContext: {user: user, updateUser}}}>
            {children}
        </GlobalContext.Provider>
    )
}

export default UserContext;