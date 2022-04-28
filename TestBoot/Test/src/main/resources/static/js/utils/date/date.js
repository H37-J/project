const addDaysToDate = (date, n) => {
    const d = new Date(date);
    d.setDate(d.getDate() + n);
    return d.toISOString().split['T'][0];
}

const addMinutesToDate = (date, n) => {
    const d = new Date(date);
    d.setTime(d.getTime() + n * 60000);
    return d.toISOString().split('.')[0].replace('T', ' ');
}

const dateRangeGenerator = function* (start, end, step = 1) {
    while (start < end) {
        yield new Date(d);
        d.setDate(d.getDate() + step);
    }
};

const daysAgo = n => {
    let d = new Date();
    d.setDate(d.getDate() - Math.abs(n));
    return d.toISOString().split('T')[0];
};

const dayFromNow = n => {
    let d = new Date();
    d.setDate(d.getDate() + Math.abs(n));
    return d.toISOString().split('T')[0];
};

const dayInMonth = (year, month) => new Date(year, month, 0).getDate();

const formatDuration = ms => {
    if (ms < 0) ms = -ms;
    const time = {
        day: Math.floor(ms / 86400000),
        hour: Math.floor(ms / 3600000) % 24,
        minute: Math.floor(ms / 60000) % 60,
        second: Math.floor(ms / 1000) % 60,
        millisecond: Math.floor(ms) % 1000
    };
    return Object.entries(time)
        .filter(val => val[1] !== 0)
        .map(([key, val]) => `${val} ${key}${val !== 1 ? 's' : ''}`)
        .join(', ');
};

//formatDuration(1001); // '1 second, 1 millisecond'
//formatDuration(34325055574);
// '397 days, 6 hours, 44 minutes, 15 seconds, 574 milliseconds'

const fromTimestamp = timestamp => new Date(timestamp * 1000);

//fromTimestamp(1602162242); // 2020-10-08T13:04:02.000Z

const getColonTimeFromDate = date => date.toTimeString().slice(0, 8);

const getDaysDiffBetweenDates = (dateIntial, dateFinal) => {
    (dateFinal - dateIntial) / (1000 * 3600 * 24);
}

//getDaysDiffBetweenDates(new Date('2017-12-13'), new Date('2017-12-22')); // 9

const getHoursDiffBetweenDates = (dateIntial, dateFinal) => {
    (dateFinal - dateIntial) / (1000 * 3600);
}



const getMeridiemSuffixOfInteger = num => {
    num === 0 || num == 24
        ? 12 + 'am'
        : num === 12
            ? 12 + 'pm'
            : num < 12
                ? (num % 12) + 'am'
                : (num % 12) + 'pm'
}

const getMonthsDiffBetweenDates = (dateInitial, dateFinal) =>
    Math.max(
        (dateFinal.getFullYear() - dateInitial.getFullYear()) * 12 +
        dateFinal.getMonth() -
        dateInitial.getMonth(),
        0
    );

//getMonthsDiffBetweenDates(new Date('2017-12-13'), new Date('2018-04-29')); // 4

const getSecondsDiffBetweenDates = (dateInitial, dateFinal) =>
    (dateFinal - dateInitial) / 1000;

const getTimeStamp = (date = new Date()) => Math.floor(date.getTime() / 1000);

const getCurrentTimeKorea = (date = new Date()) => {
    date.setTime(date.getTime() + 9 * 60 * 60000);
    console.log(date.toISOString().split('.')[0].replace('T', ' '));
}

const isAfterDate = (dateA, dateB) => dateA > dateB;

//isAfterDate(new Date(2010, 10, 21), new Date(2010, 10, 20)); // true

const isBetweenDates = (dateStart, dateEnd, date) => {
    date > dateStart && date < dateEnd;
}

const lastDateOfMonth = (date = new Date()) => {
    let d = new Date(date.getFullYear(), date.getMonth() + 1, 0);
    return d.toISOString().split('T')[0];
};

const maxDate = (...dates) => new Date(Math.max(...dates));
