const deepCopyObject = objToCopy => {
  if (objToCopy === null) {
    return null;
  }
  if (Array.isArray(objToCopy)) {
    return [...objToCopy];
  }
  if (typeof (objToCopy) !== 'object') {
    return objToCopy;
  }
  const newObj = {};
  for (const key in objToCopy) {
    if (Object.prototype.hasOwnProperty.call(objToCopy, key)) {
      newObj[key] = deepCopyObject(objToCopy[key]);
    }
  }
  return newObj;
};

export { deepCopyObject };
