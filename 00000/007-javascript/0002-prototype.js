// Prototype is how JavaScript supports inheritance. Objects can access methods defined on their prototype.
Array.prototype.myMethod = function () {
  return "Hello";
};
console.log([1, 2, 3].myMethod()); // works because of prototype



// A polyfill is a fallback implementation that makes modern JavaScript features work in older browsers.
if (!Array.prototype.includes) {
  Array.prototype.includes = function (x) {
    return this.indexOf(x) !== -1;
  };
}





Object.prototype.getValue = function (key) {
    return this[key];
}
console.log({name: 'anurag', age: 30, city: 'noida'}.getValue("age"));