const isAfterDate = (dateA, dateB) => dateA > dateB;

isAfterDate(new Date(2010, 10, 21), new Date(2010, 10, 20)); // true

const isBetweenDates = (dateStart, dateEnd, date) => date > dateStart && date < dateEnd;

isBetweenDates(new Date(2010, 11, 20), new Date(2010, 11, 30), new Date(2010, 11, 19)); // false
isBetweenDates(new Date(2010, 11, 20), new Date(2010, 11, 30), new Date(2010, 11, 25)); // true
