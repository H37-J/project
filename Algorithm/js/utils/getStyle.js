const getSytle = (el, ruleName) => getComputedStyle(el)[ruleName];

getSytle(document.querySelector('p'), 'font-size');
