import { debounce } from './debounce';

test('debounce', () => {
  const func = jest.fn();
  const debouncedFunc = debounce(func, 1000);

  // Call it immediately
  debouncedFunc();
  expect(func).toHaveBeenCalledTimes(0); // func not called

  // Call it several times with 500ms between each call
  for (let i = 0; i < 10; i += 1) {
    setTimeout(() => {
      debouncedFunc();
    }, 500);
  }
  expect(func).toHaveBeenCalledTimes(0); // func not called

  // wait 1000ms
  setTimeout(() => {
    expect(func).toHaveBeenCalledTimes(1); // func called
  }, 2000);
});
