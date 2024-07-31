const allPromises = args => new Promise((resolve, reject) => {
  const results = [];
  let resolvedPromisesCount = 0;
  args.forEach((promise, index) => {
    Promise.resolve(promise).then(result => {
      results[index] = result;
      resolvedPromisesCount += 1;
      if (resolvedPromisesCount === args.length) {
        resolve(results);
      }
    }).catch(err => reject(err));
  });
});

export { allPromises };
