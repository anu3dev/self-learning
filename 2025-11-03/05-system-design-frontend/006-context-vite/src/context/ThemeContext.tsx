import { useState, type ReactNode, useContext } from "react";
import GlobalContext from "./GlobalContext";

const ThemeContext = ({children}: {children: ReactNode}) => {
    const globalContext = useContext(GlobalContext);

    const [theme, setTheme] = useState('light');

    const toggleTheme = ():void => {
        setTheme(prev => prev === 'light' ? 'dark' : 'light')
    }

    return (
        <GlobalContext.Provider value={{ ...globalContext, themeContext: {theme, toggleTheme} }}>
            {children}
        </GlobalContext.Provider>
    )
}

export default ThemeContext;