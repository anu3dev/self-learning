// implemented with function* and yield i.e. generator

// function rangeIter(lb, ub) {
//   if (ub === undefined || typeof ub !== 'number' || lb === undefined || typeof lb !== 'number') {
//     throw new TypeError('undefined is not a number');
//   }
//   const rangeArray = [];
//   function* generateSequence(start, end) {
//     for (let i = start; i <= end; i += 1) {
//       yield i;
//     }
//   }
//   for (const value of generateSequence(lb, ub)) {
//     rangeArray.push(value);
//   }
//   return rangeArray;
// }

// implemented with iterator

function rangeIter(lb, ub) {
  if (ub === undefined || typeof ub !== 'number' || lb === undefined || typeof lb !== 'number') {
    throw new TypeError('undefined is not a number');
  }
  const rangeArray = [];
  let start = lb;
  const end = ub;
  const generateSequence = {
    [Symbol.iterator]() {
      return {
        next() {
          if (start <= end) {
            start += 1;
            return {
              value: start - 1,
              done: false,
            };
          }
          return {
            done: true,
          };
        },
      };
    },
  };

  for (const value of generateSequence) {
    rangeArray.push(value);
  }

  return rangeArray;
}

// implemented with normal js

// function rangeIter(lb, ub) {
//   if (ub === undefined || typeof ub !== 'number' || lb === undefined || typeof lb !== 'number') {
//     throw new TypeError('undefined is not a number');
//   }
//   const x = [];
//   for (let i = lb; i <= ub; i += 1) {
//     x.push(i);
//   }
//   return x;
// }

export { rangeIter };
