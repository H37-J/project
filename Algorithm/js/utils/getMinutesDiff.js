const getMinuteDiff = (DateOne, DateTwo) => (DateOne - DateTwo) / (1000 * 60);

getMinuteDiff(new Date('2021-04-24 01:00:15'), new Date('2021-04-24 02:00:15')); // 60

const getMonthsDiffBetweenDates = (dateInitial, dateFinal) =>
  Math.max(
    (dateFinal.getFullYear() - dateInitial.getFullYear()) * 12 +
      dateFinal.getMonth() -
      dateInitial.getMonth(),
    0
  );
