const sumEvenArgs = (...args) =>
{
    let evenNumber = args.filter(number => number % 2 === 0 || number === 0);
    let sumOfEvenNumber = evenNumber.reduce((a, b) => a + b, 0);
    return sumOfEvenNumber;
};

export { sumEvenArgs };
