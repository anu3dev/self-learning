function abbreviateString(str) {
  const cleanedString = str.trim().replace(/\s\s+/g, ' ').split(' ');
  const printString = `${cleanedString[0]} ${cleanedString[cleanedString.length - 1].charAt(0)}.`;
  return printString;
}

export { abbreviateString };
