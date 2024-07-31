const allSettled = args => new Promise((resolve) => {
  const results = [];
  let executedPromisesCount = 0;
  args.forEach((promise, index) => {
    Promise.resolve(promise).then(result => {
      results[index] = { status: 'fulfilled', value: result };
      executedPromisesCount += 1;
      if (executedPromisesCount === args.length) {
        resolve(results);
      }
    })
      .catch(err => {
        results[index] = { status: 'rejected', value: err };
        executedPromisesCount += 1;
        if (executedPromisesCount === args.length) {
          resolve(results);
        }
      });
  });
});
export { allSettled };
