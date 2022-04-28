//dom
const addStyles = (el, styles) => Object.assign(el.style, styles);

addStyles(document.getElementById('element'), {
    background: 'red',
    color: '#ffff00',
    fontSize: '3rem'
});

const setStyle = (el, rule, val) => (el.style(rule) = val);
setStyle(document.querySelector('p'), 'font-size', '20px');

const arrayToHTMLList = (arr, listID) => {
    document.querySelector(`#${listID}`).innerHTML += arr
        .map(item => `<li>${item}</li>`)
        .join('');
}

const createElement = str => {
    const el = document.createElement('div')
    el.innerHTML = str;
    return el.firstElementChild;
}

const el = createElement('<div class="test">test</div>');


const elmeentContains = (parent, child) => {
    parent != child && parent.contains(child);
}

const hasClass = (el, className) => el.classList.contains(className);
hasClass(document.querySelector('p.test'), 'test');

const removeClass = (el, className) => el.classList.remove(className);

const toggleClass = (el, className) => el.classList.toggle(className);

const removeElement = el => el.parentNode.removeChild(el);

const elmenetIsFocused = el => (el === document.activeElement);

const getSiblings = el => {
    [...el.parentNode.childNodes].filter(node => node !== el);
}

const getSytle = (el, ruleName) => getComputedStyle(el)[ruleName];

getSytle(document.querySelector('p'), 'font-size');

const injectCSS = css => {
    let el = document.createElement('style');
    el.type = 'text/css';
    el.innerText = css;
    document.head.appendChild(el);
    return el;
}

const insertAfter = (el, htmlString) => {
    el.insertAdjacentHTML('afterend', htmlString);
}

const insertBefore = (el, htmlString) => {
    el.insertAdjacentHTML('beforebegin', htmlString);
}





const hide = (...el) => [...el].forEach(e => e.style.display = 'none');

const findClosestMatchingNode = (node, selector) => {
    for (let n = node; n.parentNode; n = n.parentNode) {
        if (n.matches && n.matches(selector)) return n;
        return null;
    }
};

const formToObject = from => {
    Array.from(new FormData(form)).reduce(
        (acc, [key, value]) => ({
            ...acc,
            [key]: value
        }),
        {});
}
//formToObject(document.querySelector('#form'));
// { email: 'test@email.com', name: 'Test Name' }

const fullscreen = (mode = true, el = 'body') => {
    mode
        ? document.querySelector(el).requestFullscreen()
        : document.exitFullscreen();
}




//URL
const getBaseURL = url => url.replace(/[?#].*$/, '');
getBaseURL('http://url.com/page?name=Adam&surname=Smith');
// 'http://url.com/page'


const currentUrl = () => window.location.href;

const getProtocol = () => window.location.protocol; // 'https:'

const isSameOrigin = (origin, other) => {
    origin.protocol === other.protocol && origin.host === other.host;
}

const getURLParameters = url =>
    (url.match(/([^?=&]+)(=([^&]*))/g) || []).reduce(
        (a, v) => (
            (a[v.slice(0, v.indexOf('='))] = v.slice(v.indexOf('=') + 1)), a
        ),
        {}
    );
getURLParameters('google.com'); // {}
getURLParameters('http://url.com/page?name=Adam&surname=Smith');
// {name: 'Adam', surname: 'Smith'}

const queryStringToObject = url =>
    [...new URLSearchParams(url.split('?')[1])].reduce(
        (a, [k, v]) => ((a[k] = v), a),
        {}
    );

queryStringToObject('https://google.com?page=1&count=10');
// {page: '1', count: '10'}

//복사
const copyToClipboard = str => {
    const el = document.createElement('textarea');
    el.value = str;
    el.setAttribute('readonly', '');
    el.style.position = 'absolute';
    el.style.left = '-9999px';
    document.body.appendChild(el);
    const selected = document.getSelection().rangeCount > 0
        ? document.getSelection().getRangeAt(0)
        : false;
    el.select();
    document.execCommand('copy');
    document.body.removeChild(el);
    if (selected) {
        document.getSelection().removeAllRanges();
        document.getSelection().addRange(selected);
    }
};

const copyToClipboardAsync = str => {
    if (navigator && navigator.clipboard && navigator.clipboard.writeText)
        return navigator.clipboard.writeText(str);
    return Promise.reject("The Clipboard API is not avaliable.");
};


//스크롤
const getScrollPosition = (el = window) => ({
    x: el.pageXOffset !== undefined ? el.pageXOffset : el.scrollLeft,
    y: el.pageYOffset !== undefined ? el.pageYOffset : el.scrollTop
});

const getSelectedText = () => window.getSelection().toString();



//detect
const detectDeviceType = () =>
    /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
        navigator.userAgent
    )
        ? 'Mobile'
        : 'Desktop';

const detectLanguage = (defaultLang = 'en-US') =>
    navigator.language ||
    (Array.isArray(navigator.languages) && navigator.languages[0]) ||
    defaultLang;


//event
const bindAll = (obj, ...fns) => {
    fns.forEach(
        fn => (
            (f = obj[fn]),
            (obj[fn] = function () {
                return f.apply(obj);
            })
        )
    )
};

let view = {
    label: 'docs',
    click: function () {
        console.log('clicked' + this.label);
    }
};

bindAll(view, 'click');
document.body.addEventListener('click', view.click);

const off = (el, evt, fn, opts = false) => {
    el.removeEventListener(evt, fn, opts);
}

const onClickOutSide = (element, callback) => {
    document.addEventListener('click', e => {
        if (!element.contains(e.target)) callback();
    })
}

const once = fn => {
    let called = false;
    return function (...args) {
        if (called) return;
        called = true;
        return fn.apply(this, args);
    }
}

const onScrollStop = callback => {
    let isScrolling;
    window.addEventListener(
        'scroll',
        e => {
            clearTimeout(isScrolling);
            isScrolling = setTimeout(() => {
                callback();
            }, 150);
        },
        false
    );
};



//promise
const promisify = func => (...args) =>
    new Promise((resolve, reject) =>
        func(...args, (err, result) => (err ? reject(err) : resolve(result)))
    );

//etc
const escapeHTML = str =>
    str.replace(
        /[&<>'"]/g,
        tag =>
        ({
            '&': '&amp;',
            '<': '&lt;',
            '>': '&gt;',
            "'": '&#39;',
            '"': '&quot;'
        }[tag] || tag)
    );

escapeHTML('<a href="#">Me & you</a>');
// '&lt;a href=&quot;#&quot;&gt;Me &amp; you&lt;/a&gt;'

const expandTabs = (str, count) => str.replace(/\t/g, ' '.repeat(count));
expandTabs('\t\tlorem', 3); // '      lorem'

const extendHex = shortHex =>
    '#' +
    shortHex
        .slice(shortHex.startsWith('#') ? 1 : 0)
        .split('')
        .map(x => x + x)
        .join('');

extendHex('#03f'); // '#0033ff'
extendHex('05a'); // '#0055aa'

const getType = v => {
    (v === undefined ? 'undefined' : v === null ? 'null' : v.constructor.name);
}

getType(new Set([1, 2, 3])); // 'Set'


const unescapeHTML = str =>
    str.replace(
        /&amp;|&lt;|&gt;|&#39;|&quot;/g,
        tag =>
        ({
            '&amp;': '&',
            '&lt;': '<',
            '&gt;': '>',
            '&#39;': "'",
            '&quot;': '"'
        }[tag] || tag)
    );

unescapeHTML('&lt;a href=&quot;#&quot;&gt;Me &amp; you&lt;/a&gt;');
  // '<a href="#">Me & you</a>'