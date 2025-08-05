/**
 * Question: What is the React Reconciliation Algorithm?
 * Answer: The React Reconciliation Algorithm is a process that React uses to update
 * the user interface by efficiently diffing and patching the virtual DOM.
 * It determines how to update the UI when the state of a component changes,
 * ensuring minimal changes to the actual DOM for performance optimization.
 * It works by comparing the new virtual DOM with the previous one,
 * identifying changes, and applying only the necessary updates to the real DOM.
 * This algorithm is crucial for maintaining a fast and responsive user interface,
 * especially in applications with frequent updates or complex UI structures.
 */



/**
 * Question: What is Virtual DOM in React?
 * Answer: The Virtual DOM is a lightweight representation of the actual DOM in React.
 * It is a JavaScript object that mimics the structure of the real DOM. React uses the 
 * Virtual DOM to optimize rendering by minimizing direct manipulations of the real DOM. 
 * When a component's state changes, React updates the Virtual DOM first, then compares 
 * it with the previous version to determine the minimal set of changes needed for the 
 * real DOM. This process improves performance and ensures a smoother user experience.
 */



function reconcile(oldVNode, newVNode) {
  // If the old and new VNodes are the same, return the old one as no changes are needed
  // This is a shallow comparison, assuming VNodes are simple objects
  if (oldVNode === newVNode) {
    return oldVNode;
  }

  // If the new VNode is null, remove the old one
  if (newVNode === null) {
    return null;
  }

  // If the old VNode is null, create a new one
  if (oldVNode === null) {
    return newVNode;
  }

  // If the type of the VNodes is different, replace the old with the new
  if (oldVNode.type !== newVNode.type) {
    return newVNode;
  }

  // If oldVNode and newVNode are same type but not strictly equal,
  // we need to reconcile their properties and children 
  const updatedProps = { ...oldVNode.props, ...newVNode.props };
  const updatedChildren = reconcileChildren(oldVNode.children, newVNode.children);

  return {
    ...newVNode,
    props: updatedProps,
    children: updatedChildren,
  };
}   



/**
 * In below example, types are same but not strictly equal.
 * The reconciliation algorithm will update the properties and children accordingly.
 */
const oldVNode = { type: 'div', props: { className: 'a' }, children: ['Hello'] };
const newVNode = { type: 'div', props: { className: 'b' }, children: ['World'] };



/**
 * Deep copy and shallow copy are two different ways of copying objects in JavaScript.
 * Deep copy creates a new object that is a complete copy of the original object,
 * including all nested objects, while shallow copy creates a new object that is a copy
 * of the original object but only copies references to nested objects.
 */



const original = { a: 1, b: { c: 2 } };
/**
 * Example of shallow copy:
 */
const shallowCopy = { ...original };
shallowCopy.b.c = 42;
console.log(original.b.c); // 42 (nested object is shared)
/**
 * Example of deep copy:
 */
const deepCopy = JSON.parse(JSON.stringify(original));
deepCopy.b.c = 100;
console.log(original.b.c); // 42 (nested object is not affected)