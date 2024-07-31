import React, { lazy } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

const HomeScreen = lazy(() => import('../components/molecules/HomeScreen'))
const ContactUsScreen = lazy(() => import('../components/molecules/ContactUsScreen'))

const RouteConfig = () => {
  let selectedRoute = null

  switch ((window?.location?.pathname.replace('/', ''))) {
    case 'home':
      selectedRoute = <HomeScreen />
      break
    case 'contact':
      selectedRoute = <ContactUsScreen />
      break
    default:
      selectedRoute = <HomeScreen />
      break
  }
  return selectedRoute
}

const routeBasePath = '/*'

const routes = (
  <BrowserRouter>
    <Routes>
      <Route exact path={routeBasePath} element={ <RouteConfig />}/>
    </Routes>
  </BrowserRouter>
)

export default routes