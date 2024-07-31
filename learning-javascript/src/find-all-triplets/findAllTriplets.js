function findAllTriplets(arr, sum) {
  const arrSize = arr.length;
  if (!Array.isArray(arr) || arrSize <= 3 || typeof sum !== 'number') {
    throw new Error('Invalid Parameter');
  }
  for (const item of arr) {
    if (Number.isNaN(item)) {
      throw new Error('Invalid Parameter');
    }
  }
  arr.sort((x, y) => x - y);
  const result = [];
  for (let i = 0; i < arrSize - 2; i += 1) {
    let start = i + 1;
    let end = arrSize - 1;
    const tempSum = sum - arr[i];
    while (start < end) {
      const s = arr[start] + arr[end];
      if (tempSum === s) {
        result.push([arr[i], arr[start], arr[end]]);
        start += 1;
        end -= 1;
      } else if (s < tempSum) {
        start += 1;
      } else {
        end -= 1;
      }
    }
  }
  return result;
}

export { findAllTriplets };
