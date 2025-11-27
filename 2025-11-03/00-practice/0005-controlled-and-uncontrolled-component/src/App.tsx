import ControlledComponent from "./ControlledComponent"
import UnControlledComponent from "./UnControlledComponent"

function App() {
  return (
    <>
      <div className="app">
        <ControlledComponent />
        <UnControlledComponent />
      </div>
    </>
  )
}

export default App

/**
 * React.PureComponent automatically implements shouldComponentUpdate() 
 * with a shallow comparison of props and state.
 * 
 * It re-renders only if props or state actually change.
 * Prevents unnecessary re-renders.
 * 
 * class MyComponent extends React.PureComponent {
    render() {
      return <div>{this.props.value}</div>;
    }
  }
 *
 */


/**
 * React Lifecycle = 3 phases:
 *    Mounting (component born)
 *    Updating (component changes)
 *    Unmounting (component removed)
 * 
 * Mounting Methods
 *    constructor → initialize state
 *    getDerivedStateFromProps → sync props → state
 *    render → return JSX
 *    componentDidMount → API calls, DOM access
 * 
 * Updating Methods
 *    getDerivedStateFromProps → sync props
 *    shouldComponentUpdate → decide re-render
 *    render → redraw
 *    getSnapshotBeforeUpdate → read DOM before update
 *    componentDidUpdate → logic after update
 * 
 * Unmounting Method
 *    componentWillUnmount → cleanup (listeners, timers, API cancels)
 */