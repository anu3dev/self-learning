import { store } from './redux/store'
import { Provider } from 'react-redux'
import WelcomeScreen from "./components/organism/WelcomeScreen/WelcomeScreen";

function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <WelcomeScreen />
      </div>
    </Provider>
  );
}

export default App;
