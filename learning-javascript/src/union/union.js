function union(...args) {
  const firstArgs = args[0];
  const secondArgs = args[1];
  if (typeof args === 'function') {
    return 'Seems passed Args is a function.';
  }
  if (typeof args === 'object') {
    if (JSON.stringify(firstArgs) === JSON.stringify(secondArgs)) {
      return firstArgs;
    }
  }
  const mergeArgs = [...firstArgs, ...secondArgs];
  const unionOfArgs = [...new Set(mergeArgs)];
  return unionOfArgs;
}

export { union };
