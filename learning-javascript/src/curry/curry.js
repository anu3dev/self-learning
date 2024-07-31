function curry(fn) {
  return function curriedSolution(...value) {
    if (fn.length <= value.length) {
      return fn(...value);
    }
    return function curried(...moreValue) {
      return curriedSolution(...value, ...moreValue);
    };
  };
}

export { curry };
