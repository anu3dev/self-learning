function pathSatisfies (fxn, path, obj) {
  const stringToPath = function (path) {
    if (typeof path !== 'string') return path;
    let output = [];
    path.split('.').forEach(function (item) {
      item.split(/\[([^}]+)\]/g).forEach(function (key) {
			// Push to the new array
     if (key.length > 0) {
			  output.push(key);
      }
      });
    });
    return output;
  };
  path = stringToPath(path);
  let current = obj;
  for (let i = 0; i < path.length; i += 1) {
    if (!current[path[i]]) return fxn;
    current = current[path[i]];
  }
  return true;
}
export { pathSatisfies };
