/**
 * What is TypeScript?
 * 
 * TypeScript is a programming language built on top of JavaScript.
 * It adds static typing— you can tell the function what kind of data (number, string, etc.) you can expect.
 * TypeScript uses the same syntax as JavaScript, but adds extra features (types).
 */



/**
 * Why use TypeScript?
 * 
 * JavaScript is loosely typed: you don’t know what type of data is being used unless you check manually.
 * TypeScript lets you specify types for variables and function parameters.
 * This helps catch mistakes early—TypeScript will show errors if you use the wrong type.
 * TypeScript checks types before running the code (compile time), so you fix problems sooner.
 */



function addEx1(a: number, b: number): number {
  return a + b;
}
const addEx2 = (a: number, b: number): number =>  {
  return a + b;
}
/**
 * if we call the function like add(2, 3) then it won't throw an error but if we call it like add("2", "3") then TypeScript will warn you!
 * Helps prevent bugs by checking types before running code, makes code easier to understand and maintain.
 */



/**
 * Common types of primitive values in TypeScript:
 * - number: for numeric values (e.g., 1, 3.14)
 * - string: for text (e.g., "hello")
 * - boolean: true or false
 * - null: intentional absence of any value
 * - undefined: variable declared but not assigned a value
 * - symbol: unique and immutable value (rarely used)
 * - bigint: for very large integers
 */



let x = 5; // x is implicitly a number
let y: string = "hello"; // y is explicitly a string
/**
 * Implicit typing: TypeScript infers the type based on the assigned value.
 * Explicit typing: You specify the type directly.
 */



let value: any = 42; // can be any type
value = "hello"; // still valid

function logMessage(msg: string): void {
    console.log(msg);
}

function throwError(): never {
    throw new Error("Something went wrong!");
}

let user: { name: string; age: number } = { name: "Alice", age: 30 };

let names: string[] = ["Alice", "Bob", "Charlie"];
let mixedArray: (string | number)[] = ["Alice", 30, "Bob", 25];

let numbers1: Array<number> = [1, 2, 3]; // same as
let numbers2: number[] = [1, 2, 3];

let tuple: [string, number] = ["age", 25];
/**
 * Special types in TypeScript:
 * - any: disables type checking for a variable (can be any type)
 * - unknown: like any, but safer—must check type before using
 * - void: for functions that do not return a value
 * - never: for functions that never return (e.g., throw error or infinite loop)
 * - object: for non-primitive values (arrays, objects, etc.)
 * - Array<number>: array of numbers (can also use number[])
 * - Tuple: fixed-length array with specific types (e.g., [string, number])
 */



enum Status {
    Success = 200,
    NotFound = 404,
    ServerError = 500
}
/**
 * Enum is a way to define a set of named constants.
 * It helps make code more readable by using meaningful names instead of values.
 * Enum is also supported by Java.
 */



interface User {
    name: string;
    age: number;
    isActive: boolean;
}

const user1: User = {
    name: "Bob",
    age: 28,
    isActive: true
};
/**
 * What is an interface in TypeScript?
 * 
 * An interface is a way to describe the shape of an object—what properties and methods it should have.
 * It acts as a contract for objects, ensuring they have specific structure.
 * Interfaces are only used for type checking and do not exist in the compiled JavaScript.
 * 
 * 
 *  Real-time example:
 * 
 * Imagine you are building a user management system. You want every user object to have a name, age, and isActive status.
 * By using an interface, you ensure all user objects follow the same structure.
 * This helps prevent bugs and makes your code easier to maintain.
 */



let someValue: unknown = "Hello, TypeScript!";
let strLength: number = (someValue as string).length;
/**
 * "as" casting in TypeScript:
 * 
 * The "as" keyword is used to tell TypeScript to treat a value as a specific type.
 * This is called type assertion or casting.
 * It does not change the runtime value, but helps TypeScript understand your intent.
 */



/**
 * 1. What are the differences between type aliases and interfaces? When should you use each?
 * 
 * Type aliases (`type`) and interfaces (`interface`) are both used to define types in TypeScript.
 * - Interfaces are best for defining the shape of objects and can be extended or merged.
 * - Type aliases can represent any type (primitive, union, intersection, etc.) but cannot be merged.
 * Use interfaces for object shapes and when you need extensibility; use type aliases for unions, intersections, or primitives.
 */



/**
 * 2. How does TypeScript's type inference work, and how can you leverage it for cleaner code?
 * 
 * TypeScript automatically infers types based on variable initialization, function return values, and context.
 * Leveraging inference reduces explicit type annotations, making code cleaner and easier to maintain.
 * Use inference for local variables and function returns when the type is obvious.
 */



/**
 * 3. Explain generics in TypeScript. How do you create reusable generic functions and classes?
 * 
 * Generics allow you to write reusable code that works with any type.
 * You define generics using angle brackets `<T>`.
 * Example: `function identity<T>(arg: T): T { return arg; }`
 * Classes and interfaces can also be generic, enabling flexible and type-safe APIs.
 */



/**
 * 4. What is structural typing in TypeScript? How does it differ from nominal typing?
 * 
 * TypeScript uses structural typing, meaning types are compatible if their structures match, regardless of their names.
 * Nominal typing (used in languages like Java) requires explicit declarations for compatibility.
 * Structural typing enables flexible code reuse but may allow unintended compatibility.
 */



/**
 * 5. How do mapped types and conditional types work? Give examples of their use cases.
 * 
 * Mapped types transform properties of existing types (`{ [K in keyof T]: ... }`).
 * Conditional types use type logic (`T extends U ? X : Y`).
 * Use mapped types for utilities like `Partial<T>`, and conditional types for type transformations based on conditions.
 */



/**
 * 6. How do you use utility types like Partial, Pick, Omit, and Record?
 * 
 * Utility types help manipulate existing types:
 * - `Partial<T>`: Makes all properties optional.
 * - `Pick<T, K>`: Selects a subset of properties.
 * - `Omit<T, K>`: Removes specified properties.
 * - `Record<K, T>`: Creates a type with keys K and values T.
 * Use them to create flexible and reusable type definitions.
 */



/**
 * 7. What are declaration merging and module augmentation? When are they useful?
 * 
 * Declaration merging allows multiple declarations with the same name to combine.
 * Module augmentation extends existing modules with new types or members.
 * Useful for extending third-party libraries or adding custom properties to global objects.
 */



/**
 * 8. How do you handle complex union and intersection types?
 * 
 * Use unions (`A | B`) for values that can be one of several types.
 * Use intersections (`A & B`) to combine multiple types into one.
 * For complex cases, use type guards, discriminated unions, and helper types to manage type safety and readability.
 */



/**
 * 9. What are discriminated unions and how do they help with exhaustive type checking?
 * 
 * Discriminated unions use a common property (discriminator) to distinguish between types in a union.
 * They enable exhaustive type checking in switch statements, ensuring all cases are handled.
 * Example: `{ type: 'circle', radius: number } | { type: 'square', side: number }`
 */



/**
 * 10. How do you integrate TypeScript with JavaScript libraries that do not have type definitions?
 * 
 * Use `@types` packages if available. If not, create custom `.d.ts` declaration files.
 * Use `declare module` or `declare function` to define types for the library's API.
 * This enables type safety and better IDE support when using untyped libraries.
 */



/**
 * 11. How do you use enums and what are their limitations?
 * 
 * Enums define named constants, useful for representing a set of related values.
 * Limitations: Enums are not extensible, can cause issues with reverse mapping, and may increase bundle size.
 * Prefer union types for simpler use cases or when extensibility is needed.
 */



/**
 * 12. How do you ensure type safety when working with asynchronous code (Promises, async/await)?
 * 
 * Use `Promise<T>` to type asynchronous results.
 * Always specify return types for async functions.
 * Use type guards and error handling to ensure type safety in asynchronous flows.
 */



/**
 * 13. How do you use advanced configuration options in tsconfig.json for large projects?
 * 
 * Use options like `paths`, `baseUrl`, `composite`, and `references` for project structuring.
 * Enable strict type checking (`strict`, `noImplicitAny`, etc.) for better safety.
 * Use incremental builds and module resolution settings to optimize compilation.
 */



/**
 * 14. How do you write and use custom type guards?
 * 
 * Custom type guards are functions that check types at runtime and inform TypeScript about the type.
 * Example: `function isString(x: any): x is string { return typeof x === 'string'; }`
 * Use them in conditional statements to narrow types safely.
 */



/**
 * 15. How do you handle type compatibility and migration in large codebases?
 * 
 * Use gradual typing (`any`, `unknown`) to migrate incrementally.
 * Refactor code in stages, using utility types and type guards to ensure compatibility.
 * Leverage tools like `ts-migrate` and strict compiler options to catch issues early.
 */



