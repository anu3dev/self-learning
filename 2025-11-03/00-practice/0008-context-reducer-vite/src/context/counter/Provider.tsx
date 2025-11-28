import { useMemo, useReducer, type ReactNode } from "react";
import MyContext from "./MyContext";
import Reducer from "./Reducer";
import initialState from "./initialState";

const Provider = ({children}: {children: ReactNode}) => {
    const [state, dispatch] = useReducer(Reducer, initialState);

    const value = useMemo(() => ({state, dispatch}),[state])

    return (
        <MyContext.Provider value={value}>
            {children}
        </MyContext.Provider>
    )
}

export default Provider;