import React, { lazy } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

export const LoginScreen = lazy(() => import('../components/molecules/Login'))
export const MainScreen = lazy(() => import('../components/molecules/Main'))

const SelectedRoutes = () => {
  let routes = null

  switch (window?.location?.pathname.replace('/', '')) {
    case 'login':
      routes = <LoginScreen />
      break
    default:
      routes = <MainScreen />
      break
  }

  return (
    <>
      {/* <Header /> */}
      {routes}
    </>
  )
}

const routeBasePath = '/*'

const RoutesConfig = (
  <BrowserRouter>
    <Routes>
      <Route exact path={routeBasePath} element={<SelectedRoutes />} />
    </Routes>
  </BrowserRouter>
)

export default RoutesConfig
