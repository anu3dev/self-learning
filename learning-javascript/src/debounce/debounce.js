function debounce(callFn, delayTime) {
  let debounceTime;
  return (...args) => {
    if (debounceTime) {
      clearTimeout(debounceTime);
    }
    debounceTime = setTimeout(() => {
      callFn.apply(this, args);
    }, delayTime);
  };
}

export { debounce };
