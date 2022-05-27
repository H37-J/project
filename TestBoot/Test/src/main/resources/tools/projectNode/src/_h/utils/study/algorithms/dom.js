const createElement = (str) => {
  const el = document.createElement('div')
  el.innerHTML = str
  return el.firstElementChild
}

const removeElement = (el) => el.parentNode.removeChild(el)

const elementContains = (praent, child) => {
  parent != child && parent.contains(child)
}

const arrayToHTMLList = (arr, listID) => {
  document.querySelector(`#${listID}`).innerHTML += arr.map((item) => `<li>${item}</li>`).join('')
}

const hassClass = (el, className) => el.classList.contains(className)

const removeClass = (el, className) => el.classList.remove(className)

const toggleClass = (el, className) => el.classList.toggle(className)

const elementIsFocused = (el) => el === document.activeElement

const getSiblings = (el) => {
  ;[...el.parentNode.childNodes].filter((node) => node !== el)
}

const insertAfter = (el, htmlString) => {
  el.insertAdjacentHTML('afterend', htmlString)
}

const insertBefore = (el, htmlString) => {
  el.insertAdjacentHTML('beforebegin', htmlString)
}

//style
const getStyle = (el, rule) => getComputedStyle(el)[rule]

const addStyles = (el, style) => Object.assign(el.style, style)

const setStyle = (el, rule, val) => (el.style[rule] = val)

const hide = (...el) => [...el].forEach((e) => (e.style.display = 'none'))

const injectCSS = (css) => {
  let el = document.createElement('style')
  el.type = 'text/css'
  el.innerText = css
  document.head.appendChild(el)
  return el
}

const formToObject = (from) => {
  Array.from(new FormDdata(form)).reduce(
    (acc, [key, value]) => ({
      ...acc,
      [key]: value,
    }),
    {}
  )
}
//formToObject(document.querySelector('#form'));
// { email: 'test@email.com', name: 'Test Name' }

const fullscreen = (mode = true, el = 'body') => {
  mode ? document.querySelector(el).requestFullscreen() : document.exitFullscreen()
}

//URL
const getBaseURL = (url) => url.replace(/[?#].*$/, '')
getBaseURL('http://url.com/page?name=Adam&surname=Smith')
// 'http://url.com/page'

const currentUrl = () => window.location.href

const getProtocol = () => window.location.protocol // 'https:'

const isSameOrigin = (origin, other) => {
  origin.protocol === other.protocol && origin.host === other.host
}

const getURLParameters = (url) =>
  (url.match(/([^?=&]+)(=([^&]*))/g) || []).reduce(
    (a, v) => ((a[v.slice(0, v.indexOf('='))] = v.slice(v.indexOf('=') + 1)), a),
    {}
  )
getURLParameters('google.com') // {}
getURLParameters('http://url.com/page?name=Adam&surname=Smith')

const queryStringToObject = (url) =>
  [...new URLSearchParams(url.split('?')[1])].reduce((a, [k, v]) => ((a[k] = v), a), {})

queryStringToObject('https://google.com?page=1&count=10')

//복사
const copyToClipboard = (str) => {
  const el = document.createElement('textarea')
  el.value = str
  el.setAttribute('readonly', '')
  el.style.position = 'absolute'
  el.style.left = '-9999px'
  document.body.appendChild(el)
  const selected =
    document.getSelection().rangeCount > 0 ? document.getSelection().getRangeAt(0) : false
  el.select()
  document.execCommand('copy')
  document.body.removeChild(el)
  if (selected) {
    document.getSelection().removeAllRanges()
    document.getSelection().addRange(selected)
  }
}

const copyToClipboardAsync = (str) => {
  if (navigator && navigator.clipboard && navigator.clipboard.writeText)
    return navigator.clipboard.writeText(str)
  return Promise.reject('The Clipboard API is not avaliable.')
}

//스크롤
const getScrollPosition = (el = window) => ({
  x: el.pageXOffset !== undefined ? el.pageXOffset : el.scrollLeft,
  y: el.pageYOffset !== undefined ? el.pageYOffset : el.scrollTop,
})

const getSelectedText = () => window.getSelection().toString()

//detect
const detectDeviceType = () =>
  /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)
    ? 'Mobile'
    : 'Desktop'

const detectLanguage = (defaultLang = 'en-US') =>
  navigator.language ||
  (Array.isArray(navigator.languages) && navigator.languages[0]) ||
  defaultLang

//event
const bindAll = (obj, ...fns) => {
  fns.forEach(
    (fn) => (
      (f = obj[fn]),
      (obj[fn] = function () {
        return f.apply(obj)
      })
    )
  )
}

let view = {
  label: 'docs',
  click: function () {
    console.log('clicked' + this.label)
  },
}

bindAll(view, 'click')
document.body.addEventListener('click', view.click)

const off = (el, evt, fn, opts = false) => {
  el.removeEventListener(evt, fn, opts)
}

const onClickOutSide = (element, callback) => {
  document.addEventListener('click', (e) => {
    if (!element.contains(e.target)) callback()
  })
}

const once = (fn) => {
  let called = false
  return function (...args) {
    if (called) return
    called = true
    return fn.apply(this, args)
  }
}

const onScrollStop = (callback) => {
  let isScrolling
  window.addEventListener(
    'scroll',
    (e) => {
      clearTimeout(isScrolling)
      isScrolling = setTimeout(() => {
        callback()
      }, 150)
    },
    false
  )
}

//etc
const escapeHTML = (str) =>
  str.replace(
    /[&<>'"]/g,
    (tag) =>
      ({
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        "'": '&#39;',
        '"': '&quot;',
      }[tag] || tag)
  )

escapeHTML('<a href="#">Me & you</a>')
// '&lt;a href=&quot;#&quot;&gt;Me &amp; you&lt;/a&gt;'

const unescapeHTML = (str) =>
  str.replace(
    /&amp;|&lt;|&gt;|&#39;|&quot;/g,
    (tag) =>
      ({
        '&amp;': '&',
        '&lt;': '<',
        '&gt;': '>',
        '&#39;': "'",
        '&quot;': '"',
      }[tag] || tag)
  )

unescapeHTML('&lt;a href=&quot;#&quot;&gt;Me &amp; you&lt;/a&gt;')

export {
  createElement,
  removeElement,
  elementContains,
  arrayToHTMLList,
  unescapeHTML,
  hassClass,
  removeClass,
  toggleClass,
  insertAfter,
  insertBefore,
  setStyle,
  getStyle,
  addStyles,
}
