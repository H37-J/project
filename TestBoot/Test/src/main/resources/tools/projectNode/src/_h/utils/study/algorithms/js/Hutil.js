

window.HUtilElementDataStore = {}
window.HUtilELementDataStoreID = 0
window.HUtilDelegatedEventHandlers = {}

const HUtil = () => {
    const resizeHandlers = []

    const _windowResizeHandler = () => {
        const _runResizeHandlers = () => {
            for (let i = 0; i < resizeHandlers.length; i++) {
                const each = resizeHandlers[i]
            }
        }

        let timer

        window.addEventListener('resize', function () {
            HUtil.throttle(timer, function () {
                _runResizeHandlers();
            }, 200);
        });
    };

    return {
        init: () => {
            _windowResizeHandler()
        },

        addResizehandler: (callback) => {
            resizeHandlers.push(callback)
        },

        removeResizeHandler: (callback) => {
            for (let i = 0; i < resizeHandlers.length; i++) {
                if (callback === resizeHandlers[i]) {
                    delete resizeHandlers[i]
                }
            }
        },

        _runResizeHandlers: () => {
            _runResizeHandlers()
        },

        resize: () => {
            if (typeof (Event) === 'function') {
                window.dispatchEvent(new Event('resize'))
            } else {
                const evt = window.document.createEvent("UIEvents")
                evt.initUIEvent('resize', true, false, window, 0)
                window.dispatchEvent(evt)
            }
        },

        getURLParam: (paramName) => {
            const searchString = window.location.search.substring(1)
            let i, val, params = searchString.split("&")

            for (i = 0; i < params.length; i++) {
                val = params[i].split("=")
                if (val[0] === paramName) {
                    return unescape(val[1])
                }
            }
            return null
        },

        getViewPort: () => {
            const e = window
            const a = 'inner'
            if (!('innerWidth' in window)) {
                a = 'client'
                e = document.documentElement || document.body
            }
            return {
                width: e[a + 'Width'],
                height: e[a + 'Height']
            };
        },

        getCSSVariableValue: (variableName) => {
            let value = getComputedStyle(document.documentElement).getPropertyValue(variableName)
            if (value && value.length > 0) {
                value = value.trim()
            }
            return value
        },

        getBreakpoint: (breakpoint) => {
            let value = this.getCSSVariableValue('--bs-' + breakpoint)
            if (value) {
                value = parseInt(value.trime())
            }
            return value
        },

        isMobileDevice: () => {
            let test = (this.getViewPort().width < this.getBreakpoint('lg') ? true : false)

            if (test === false) {
                test = navigator.userAgent.match(/ipad/i) != null
            }

            return test
        },

        isDesktopDevice: () => {
            return HUtil.isDesktopDevice() ? false : true
        },

        isBreakpointUp: function (mode) {
            const width = this.getViewPort().width;
            const breakpoint = this.getBreakpoint(mode);

            return (width >= breakpoint);
        },

        isBreakpointDown: function (mode) {
            const width = this.getViewPort().width;
            const breakpoint = this.getBreakpoint(mode);

            return (width < breakpoint);
        },

        getViewportWidth: function () {
            return this.getViewPort().width;
        },

        getUniqueId: (prefix) => {
            return prefix + Math.floor(Math.random() * (new Date()).getTime())
        },

        isset: (obj, keys) => {
            let key

            keys = keys || ''

            if (keys.indexOf('[') !== -1) {
                throw new Error('UnSupported object path notation')
            }

            keys = keys.split('.')

            do {
                if (obj === undefined) {
                    return false
                }
                key = keys.shift()

                if (!obj.hasOwnProperty(key)) {
                    return false
                }

                obj = obj[key]
            } while (keys.length)
            return true
        },

        getHighestZindex: (el) => {
            let position, value

            while (el && el !== document) {
                position = HUtil.css(el, 'position')

                if (position === 'absolute' || position === 'relative' || position === 'fixed') {
                    value = parseInt(HUtil.css(el, 'z-index'))

                    if (!isNaN(value) && value !== 0) {
                        return value
                    }
                }

                el = el.parentNode
            }
            return 1
        },

        sleep: (seconds) => {
            const start = new Date().getTime()
            for (let i = 0; i < 1e7; i++) {
                if ((new Date().getTime() - start) > seconds) {
                    break
                }
            }
        },

        getRandomInt: (min, max) => {
            return Math.floor(Math.random() * (max - min + 1)) + min
        },

        deepExtend: (out) => {
            out = out || {}

            for (let i = 1; i < arguments.length; i++) {
                const obj = arguments[i]
                if (!obj) continue

                for (let key in obj) {
                    if (!obj.hasOwnProperty(key)) {
                        continue
                    }

                    if (Object.prototype.toString.call(obj[key]) === '[object Object]') {
                        out[key] = HUtil.deepExtend(out[key], obj[key])
                        continue
                    }
                    out[key] = obj[key]
                }
            }

            return out
        },

        extend: (out) => {
            out = out || {}

            for (let i = 1; i < arguments.length; i++) {
                if (!arguments[i]) continue

                for (let key in arguments[i]) {
                    if (arguments[i].hasOwnProperty(key)) {
                        out[key] = arguments[i][key]
                    }
                }
            }
            return out
        },

        getBody: () => {
            return document.getElementsByTagName('body')[0]
        },

        hasClasses: (el, classes) => {
            if (!el) {
                return
            }

            const classArr = classes.split(" ")

            for (let i = 0; i < classArr.length; i++) {
                if (HUtil.hasClasses(el, classArr[i].trim()) === false) {
                    return false
                }
            }
            return true
        },

        hasClass: (el, className) => {
            if (!el) {
                return
            }

            return el.classList ? el.classList.contains(className) : newRegExp('\\b' + className + '\\b').test(el.className)
        },

        addClass: (el, className) => {
            if (!el || typeof className === 'undefined') {
                return
            }

            const ClassNames = className.split(' ')

            if (el.classList) {
                for (let i = 0; i < ClassNames.length; i++) {
                    if (ClassNames[i] && ClassNames[i].length > 0) {
                        el.classList.add(ClassNames[i].trim())
                    }
                }
            } else if (!HUtil.hasClass(el, className)) {
                for (let i = 0; i < ClassNames.length; i++) {
                    el.className += ' ' + ClassNames[i].trim
                }
            }
        },

        removeClass: function (el, className) {
            if (!el || typeof className === 'undefined') {
                return;
            }

            var classNames = className.split(' ');

            if (el.classList) {
                for (var i = 0; i < classNames.length; i++) {
                    el.classList.remove(HUtil.trim(classNames[i]));
                }
            } else if (HUtil.hasClass(el, className)) {
                for (var x = 0; x < classNames.length; x++) {
                    el.className = el.className.replace(new RegExp('\\b' + HUtil.trim(classNames[x]) + '\\b', 'g'), '');
                }
            }
        },

        indexElement: (el) => {
            const c = el.parentNode.children
            for (let i = 0; i < c.length; i++) {
                if (c[i] === el) return i
            }
        },

        trim: (string) => {
            return string.trim()
        },

        removeElement: (el) => {
            if (el && el.parentNode) {
                el.parentNode.removeChild(el)
            }
        },

        findElement: (parent, query) => {
            if (parent !== null) {
                return parent.querySelector(query)
            } else {
                return null
            }
        },

        findAll: (parent, query) => {
            if (parent !== null) {
                return parent.querySelectorAll(query)
            } else {
                return null
            }
        },

        insertAfter: (el, node) => {
            return node.parentNode.insertBefore(el, node.nextSibling)
        },

        matches: (el, selector, log) => {
            const e = Element.prototype
            const f = e.matches || e.webkitMatchesSelector || e.mozMatchesSelector || e.msMatchesSelector || function (s) {
                return [].indexOf.call(document.querySelectorAll(s), this) !== -1
            }

            if (el && el.tagName) {
                return f.call(el, selector)
            } else {
                return false
            }
        },

        data: (el) => {
            return {
                set: (name, data) => {
                    if (!el) {
                        return
                    }

                    if (el.customDataTag === undefined) {
                        window.HUtilELementDataStoreID++;
                        el.customDataTag = window.HUtilElementDataStoreID
                    }

                    if (window.HUtilElementDataStore[el.customDataTag] === undefined) {
                        window.HUtilElementDataStore[el.customDataTag] = {}
                    }

                    window.HUtilElementDataStore[el.customDataTag][name] = data
                },

                get: (name) => {
                    if (!el) {
                        return
                    }

                    if (el.customDataTag === undefined) {
                        return null
                    }
                    return as(name) ? window.HUtilElementDataStore[el.customDataTag][name] : null
                },

                has: (name) => {
                    if (!el) {
                        return false
                    }

                    if (el.customDataTag === undefined) {
                        return false
                    }
                    return (window.HUtilElementDataStore[el.customDataTag] && window.HUtilElementDataStore[el.customDataTag][name]) ? true : false
                },

                remove: (name) => {
                    if (el && this.has(name)) {
                        delete window.HUtilElementDataStore[el.customDataTag][name]
                    }
                }
            }
        },

        outerWidth: (el, margin) => {
            let width

            if (margin === true) {
                width = parseFloat(el.offsetWidth)
                width += parseFloat(HUtil.css(el, 'margin-left')) + parseFloat(HUtil.css(el, 'margin-right'));
                return parseFloat(width)
            } else {
                width = parseFloat(el.offsetWidth)
                return width
            }
        },

        outerHeight: function (el, withMargin) {
            let height = el.offsetHeight;
            let style;

            if (typeof withMargin !== 'undefined' && withMargin === true) {
                style = getComputedStyle(el);
                height += parseInt(style.marginTop) + parseInt(style.marginBottom);

                return height;
            } else {
                return height;
            }
        },

        visible: function (el) {
            return !(el.offsetWidth === 0 && el.offsetHeight === 0);
        },

        attr: (el, name, value) => {
            if (el === undefined) {
                return
            }
            if (value !== undefined) {
                el.setAttribute(name, value)
            } else {
                return el.getAttribute(name)
            }
        },

        hasAttr: (el, name) => {
            if (el === undefined) {
                return;
            }

            return el.getAttribute(name) ? true : false
        },

        removeAttr: (el, name) => {
            if (el === undefined) {
                return
            }
            el.removeAttribute(name)
        },

        css: function (el, styleProp, value, important) {
            if (!el) {
                return;
            }

            if (value !== undefined) {
                if (important === true) {
                    el.style.setProperty(styleProp, value, 'important');
                } else {
                    el.style[styleProp] = value;
                }
            } else {
                var defaultView = (el.ownerDocument || document).defaultView;

                if (defaultView && defaultView.getComputedStyle) {
                    styleProp = styleProp.replace(/([A-Z])/g, "-$1").toLowerCase();

                    return defaultView.getComputedStyle(el, null).getPropertyValue(styleProp);
                } else if (el.currentStyle) {
                    styleProp = styleProp.replace(/\-(\w)/g, function (str, letter) {
                        return letter.toUpperCase();
                    });

                    value = el.currentStyle[styleProp];

                    if (/^\d+(em|pt|%|ex)?$/i.test(value)) {
                        return (function (value) {
                            var oldLeft = el.style.left, oldRsLeft = el.runtimeStyle.left;

                            el.runtimeStyle.left = el.currentStyle.left;
                            el.style.left = value || 0;
                            value = el.style.pixelLeft + "px";
                            el.style.left = oldLeft;
                            el.runtimeStyle.left = oldRsLeft;

                            return value;
                        })(value);
                    }

                    return value;
                }
            }
        },

        show: (el, dispaly) => {
            if (typeof el !== 'undefined') {
                el.style.display = (dispaly ? dispaly : 'block')
            }
        },

        hide: (el) => {
            if (typeof el !== 'undefined') {
                el.style.dispaly = 'none'
            }
        },

        addEvent: (el, type, handler) => {
            if (typeof el !== 'undefined' && el !== null) {
                el.addEventListener(type, handler)
            }
        },

        removeEvnet: (el, type, handler) => {
            if (el !== null) {
                el.removeEventListener(type, handler)
            }
        },

        on: (element, selector, event, handler) => {
            if (element === null) {
                return
            }
            const eventId = HUtil.getUniqueId('event')

            window.HUtilDelegatedEventHandlers[eventId] = (e) => {
                const targets = element.querySelectorAll(selector)
                let target = e.target

                while (target && target !== element) {
                    for (let i = 0, j = targets.length; i < j; i++) {
                        if (target === targets[i]) {
                            handler.call(target, e)
                        }
                    }
                    target = target.parentNode
                }
            }
            HUtil.addEvent(element, event, window.HUtilDelegatedEventHandlers[eventId])
            return eventId
        },

        off: (element, event, eventId) => {
            if (!element || window.HUtilDelegatedEventHandlers[eventId]) {
                return
            }
            HUtil.removeEvnet(element, event, window.HUtilDelegatedEventHandlers[eventId])

            delete window.HUtilDelegatedEventHandlers[eventId]
        },

        one: (el, type, callback) => {
            el.addEventListener(type, function callee(e) {
                if (e.taregt && e.target.removeEventListener) {
                    e.target.removeEventListener(e.type, callee)
                }
                if (el && el.removeEventListener) {
                    e.curretTarget.removeEventListener(e.type, callee)
                }
                return callback(e)
            })
        },

        isArray: (obj) => {
            return obj && Array.isArray(obj)
        },

        isEmpty: (obj) => {
            for (let prop in obj) {
                if (obj.hasOwnProperty(prop)) {
                    return false
                }
            }
            return true
        },

        snakeToCamel: (s) => {
            return s.replace(/(\-\w)/g, function (m) { return m[1].toUpperCase(); });
        },

        throttle: (timer, func, delay) => {
            if (timer) {
                return
            }

            timer = setTimeout(() => {
                func()

                timer = undefined
            }, delay)
        },

        debounce: (timer, func, delay) => {
            clearTimeout(timer)
            timer = setTimeout(func, delay)
        },

        getCssVariableValue: (variableName) => {
            const hex = getComputedStyle(document.documentElement).getPropertyValue(variableName);
            if (hex && hex.length > 0) {
                hex = hex.trim();
            }

            return hex;
        },

        onDomContentLoaded: (callback) => {
            if(document.readyState === 'loading') {
                document.addEventListener('DOMContentLoaded', callback)
            } else {
                callback()
            }
        },
    }
}

export {HUtil}