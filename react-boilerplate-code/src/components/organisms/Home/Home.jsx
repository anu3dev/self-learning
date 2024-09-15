import React, { Suspense } from 'react'
import RoutesConfig from '../../../routes/RoutesConfig'

const Home = () => {
  return <Suspense fallback>{RoutesConfig}</Suspense>
}

export default Home
