import { render } from '@testing-library/react';
import { Provider } from 'react-redux'
import { store } from '../../../redux/store'
import HomeScreen from './HomeScreen'

describe('HomeScreen', () => {
    it('render without crashing', () => {
        render(
            <Provider store={store}>
                <HomeScreen />
            </Provider>
        );
    })
})