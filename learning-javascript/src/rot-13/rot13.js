function rot13(args) {
    //variable for shifting 13 places
    let place = 13;
  // Make an output variable
  let output = "";
  // Go through each character
  for (let i = 0; i < args.length; i++) {
    // Get the character we'll be appending
    let c = args[i];

    // If it's a letter...
    if (c.match(/[a-z]/i)) {
      // Get its message
      let message = args.charCodeAt(i);

      // Uppercase letters
      if (message >= 65 && message <= 90) {
        c = String.fromCharCode(((message - 65 + place) % 26) + 65);
      }

      // Lowercase letters
      else if (message >= 97 && message <= 122) {
        c = String.fromCharCode(((message - 97 + place) % 26) + 97);
      }
    }

    // Append
    output += c;
  }

  // All done!
  return output;
}

export {
  rot13,
};
