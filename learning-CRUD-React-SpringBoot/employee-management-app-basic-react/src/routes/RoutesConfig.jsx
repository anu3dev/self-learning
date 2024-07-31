import React, { lazy } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

export const EmployeeListScreen = lazy(() => import('../components/molecules/EmployeeListScreen'))
export const EmployeeAddScreen = lazy(() => import ('../components/molecules/EmployeeAddScreen'))

const SelectedRoutes = () => {
  let routes = null

  switch ((window?.location?.pathname.replace('/', ''))) {
    case 'add':
      routes = <EmployeeAddScreen />
      break
    default:
      routes = <EmployeeListScreen />
      break
  }
  return routes
}

const routeBasePath = '/*'

const RoutesConfig = (
  <BrowserRouter>
    <Routes>
      <Route exact path={routeBasePath} element={ <SelectedRoutes />}/>
    </Routes>
  </BrowserRouter>
)

export default RoutesConfig

