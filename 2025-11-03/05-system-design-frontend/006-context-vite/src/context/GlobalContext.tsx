import { createContext } from "react";
import initialValue from './initialValue'

const GlobalContext = createContext(initialValue);

export default GlobalContext;