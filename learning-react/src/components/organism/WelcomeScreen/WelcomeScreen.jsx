import React, { Suspense } from "react"
import routes from '../../../routes/routes'

const WelcomeScreen = () => {
    return (
        <Suspense fallback>{routes}</Suspense>
    )
}

export default WelcomeScreen