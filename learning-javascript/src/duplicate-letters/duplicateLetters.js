function duplicateLetters(args) {
  const temparr = args.split('');
  const counts = [];

  for (let i = 0; i < temparr.length; i++) {
    if (counts[temparr[i]]) {
      counts[temparr[i]] += 1;
    } else {
      counts[temparr[i]] = 1;
    }
  }
  for (const prop in counts) {
    if (counts[prop] >= 2) {
      counts.push(counts[prop]);
    }
  }
  const maxLength = Math.max(...counts);
  if (maxLength <= 1) {
    return false;
  }
  return maxLength;
}

export {
  duplicateLetters,
};
