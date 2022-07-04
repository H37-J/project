export const createElement = (str) => {
  const el = document.createElement('div')
  el.innerHTML = str
  return el.firstElementChild
}

export const removeElement = (el) => el.parentNode.removeChild(el)

export const elementContains = (parent, child) => {
  parent != child && parent.contains(child)
}

export const arrayToHTMLList = (arr, listID) => {
  document.querySelector(`#${listID}`).innerHTML += arr.map((item) => `<li>${item}</li>`).join('')
}

export const hasClass = (el, className) => el.classList.contains(className)

export const removeClass = (el, className) => el.classList.remove(className)

export const toggleClass = (el, className) => el.classList.toggle(className)

export const elementIsFocused = (el) => el === document.activeElement

export const getSiblings = (el) => {
  ;[...el.parentNode.childNodes].filter((node) => node !== el)
}

export const insertAfter = (el, htmlString) => {
  el.insertAdjacentHTML('afterend', htmlString)
}

export const insertBefore = (el, htmlString) => {
  el.insertAdjacentHTML('beforebegin', htmlString)
}

//style
export const getStyle = (el, rule) => getComputedStyle(el)[rule]

export const addStyles = (el, style) => Object.assign(el.style, style)

export const setStyle = (el, rule, val) => (el.style[rule] = val)

export const hide = (...el) => [...el].forEach((e) => (e.style.display = 'none'))

export const injectCSS = (css) => {
  let el = document.createElement('style')
  el.type = 'text/css'
  el.innerText = css
  document.head.appendChild(el)
  return el
}

export const formToObject = (form) => {
  Array.from(new FormData(form)).reduce(
    (acc, [key, value]) => ({
      ...acc,
      [key]: value,
    }),
    {}
  )
}
//formToObject(document.querySelector('#form'));
// { email: 'test@email.com', name: 'Test Name' }

export const fullscreen = (mode = true, el = 'body') => {
  mode ? document.querySelector(el).requestFullscreen() : document.exitFullscreen()
}

//URL
export const getBaseURL = (url) => url.replace(/[?#].*$/, '')
getBaseURL('http://url.com/page?name=Adam&surname=Smith')
// 'http://url.com/page'

export const currentUrl = () => window.location.href

export const getProtocol = () => window.location.protocol // 'https:'

export const isSameOrigin = (origin, other) => {
  return origin.protocol === other.protocol && origin.host === other.host
}

export const getURLParameters = (url) =>
  (url.match(/([^?=&]+)(=([^&]*))/g) || []).reduce(
    (a, v) => ((a[v.slice(0, v.indexOf('='))] = v.slice(v.indexOf('=') + 1)), a),
    {}
  )
getURLParameters('google.com') // {}
getURLParameters('http://url.com/page?name=Adam&surname=Smith')

export const queryStringToObject = (url) =>
  [...new URLSearchParams(url.split('?')[1])].reduce((a, [k, v]) => ((a[k] = v), a), {})

queryStringToObject('https://google.com?page=1&count=10')

//복사
export const copyToClipboard = (str) => {
  const el = document.createElement('textarea')
  el.value = str
  el.setAttribute('readonly', '')
  el.style.position = 'absolute'
  el.style.left = '-9999px'
  document.body.appendChild(el)
  const selected =
    getSelection().rangeCount > 0 ? document.getSelection().getRangeAt(0) : false
  el.select()
  document.execCommand('copy')
  document.body.removeChild(el)
  if (selected) {
    document.getSelection().removeAllRanges()
    document.getSelection().addRange(selected)
  }
}

export const copyToClipboardAsync = (str) => {
  if (navigator && navigator.clipboard && navigator.clipboard.writeText)
    return navigator.clipboard.writeText(str)
  return Promise.reject('The Clipboard API is not avaliable.')
}

//스크롤
export const getScrollPosition = (el = window) => ({
  x: el.pageXOffset !== undefined ? el.pageXOffset : el.scrollLeft,
  y: el.pageYOffset !== undefined ? el.pageYOffset : el.scrollTop,
})

export const getSelectedText = () => window.getSelection().toString()

//detect
export const detectDeviceType = () =>
  /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)
    ? 'Mobile'
    : 'Desktop'

export const detectLanguage = (defaultLang = 'en-US') =>
  navigator.language ||
  (Array.isArray(navigator.languages) && navigator.languages[0]) ||
  defaultLang

//event
export const bindAll = (obj, ...fns) => {
  fns.forEach(
    (fn) => (
      (fn = obj[fn]),
      (obj[fn] = function () {
        return fn.apply(obj)
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

export const off = (el, evt, fn, opts = false) => {
  el.removeEventListener(evt, fn, opts)
}

export const onClickOutSide = (element, callback) => {
  document.addEventListener('click', (e) => {
    if (!element.contains(e.target)) callback()
  })
}

export const once = (fn) => {
  let called = false
  return function (...args) {
    if (called) return
    called = true
    return fn.apply(this, args)
  }
}

export const onScrollStop = (callback) => {
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
export const escapeHTML = (str) =>
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

export const unescapeHTML = (str) =>
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

