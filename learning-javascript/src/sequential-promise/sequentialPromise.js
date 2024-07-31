function sequentialPromise(array) {
  let result = Promise.resolve();
  for (let i = 0; i < array.length; i += 1) {
    result = result.then(array[i]);
  }
  return result;
}
/* function sequentialPromise(array) {
  let result = Promise.resolve();
  array.forEach(arr => {
    result = result.then(() => arr());
  });
  return result;
} */
  
export { sequentialPromise };
 