"use strict";
window.ElementDataStore = {};
window.ElementDataStoreID = 0;
window.DelegatedEventHandlers = {};


export default class Utils {

    constructor() {
    }

    getURLParam(paramName) {
        //window.location.search ?부터 검색
        let searchString = window.location.search.substring(1);
        let i, val, params = searchString.split("&");

        for (i = 0; i < params.length; i++) {
            val = params[i].split("=");
            if (val[0] == paramName) {
                return unescape(val[1]);
            }
        }
        return null;
    }

    getCssValue(variableName) {
        let hex = getComputedStyle(document.documentElement).getPropertyValue(variableName);
        if (hex && hex.lenght > 0) {
            hex = hex.trim();
        }
        return hex;
    }

    getBreakpoint(breakpoint) {
        let value = this.getCssValue('--bs-' + breakpoint);

        if (value) {
            value = parseInt(value.trim());
        }
        return value;
    }

    getViewPort() {
        let e = window,
            a = 'inner';
        if (!('innerWidth' in window)) {
            a = 'client';
            e = documnet.documentElement || document.body;
        }

        return {
            width: e[a + 'Width'],
            height: e[a + 'Height']
        };
    }

    isMobileDevice() {
        let test = (this.getViewPort().width < this.getBreakpoint('lg') ? true : false);
        if (test === false) {
            test = navigator.userAgent.match(/iPad/i) != null;
        }

        return test;
    }

    getUniqueId(prefix) {
        return prefix + Math.floor(Math.random() * (new Date()).getTime());
    }

    trim(str) {
        return str.trim();
    }

    hasClass(el, className) {
        if (!el) {
            return;
        }
        return el.classList ? el.classList.contains(className) : new RegExp('\\b' + className + '\\b').test(el.className);
    }

    addClass(el, className) {
        if (!el || typeof className === 'undefined') {
            return;
        }
        let classNames = className.split(' ');
        if (el.classList) {
            for (let i = 0; i < classNames.length; i++) {
                if (classNames[i] && classNames[i].length > 0) {
                    el.classList.add(this.trim(classNames[i]));
                }
            }
        } else if (!this.hasClass(el, className)) {
            for (var x = 0; x < classNames.length; x++) {
                el.className += ' ' + this.trim(classNames[x]);
            }
        }
    }

    visible(el) {
        return !(el.offsetWidth === 0 && el.offsetHeight === 0);
    }

    att(el, name, value) {
        if (el === undefined) {
            return;
        }

        if (value !== undefined) {
            el.setAttribute(name, value);
        } else {
            return el.getAttribute(name);
        }
    }

    hasAttr(el, name) {
        if (el == undefined) return;
        el.getAttribute(name) ? true : false;
    }

    removeAttr(el, name) {
        if (el === undefined) return;
        el.removeAttribute(name);
    }

    show(el, display) {
        if (typeof el !== 'undefined') {
            el.style.display = (display ? display : 'block');
        }
    }

    hide(el) {
        if (typeof el !== 'undefined') {
            el.style.display = 'none';
        }
    }

    addEvent(el, type, handler) {
        if (typeof el !== 'undefined' && el !== null) {
            el.addEventListener(type, handler);
        }
    }

    on(element, selector, event, handler) {
        if (element === null) {
            return;
        }

        var eventId = this.getUniqueId('event');

        this.DelegatedEventHandlers[eventId] = function (e) {
            var targets = element.querySelectorAll(selector);
            var target = e.target;


            while (target && target !== element) {
                for (var i = 0, j = targets.length; i < j; i++) {
                    if (target === targets[i]) {
                        handler.call(target, e);
                    }
                }

                target = target.parentNode;
            }
        }


        this.addEvent(element, event, this.DelegatedEventHandlers[eventId]);
        return eventId;
    }

    removeEvent(el, type, handler) {
        if (el !== null) {
            el.removeEventListener(type, handler);
        }
    }

    isArray(obj) {
        return obj && Array.isArray(obj);
    }

    isEmpty(obj) {
        for (let prop in obj) {
            if (obj.hasOwnProperty(prop)) {
                return false;
            }
        }
        return true;
    }

    setHTML(el, html) {
        el.innerHTML = html;
    }

    onDomContentLoaded(callback) {
        if (document.readyState === 'loading') {
            documnet.addEventListener('DOMContentLoaded', callback);
        } else {
            callback();
        }
    }

    isHexColor(code) {
        return /^#[0-9A-F]{6}$/i.test(code);
    }

    find(parent, query) {
        if (parent !== null) {
            return parent.querySelector(query);
        } else {
            return null;
        }
    }

    findAll(parent, query) {
        if (parent !== null) {
            return parent.querySelectorAll(query);
        } else {
            return null;
        }
    }

    data(el) {
        return {
            set(name, data) {
                if (!el) {
                    return;
                }

                if (el.customDataTag === undefined) {
                    window.ElementDataStoreID++;
                    el.customDataTag = window.ElementDataStoreID;
                }

                if (window.ElementDataStore[el.customDataTag] === undefined) {
                    window.ElementDataStore[el.customDataTag] = {}
                }

                window.ElementDataStore[el.customDataTag][name] = data;
            },

            get(name) {
                if (!el) {
                    return;
                }

                if (el.customDataTag === undefined) {
                    return null;
                }

                return this.has(name) ? window.ElementDataStore[el.customDataTag][name] : null;
            },

            has(name) {
                if (!el) {
                    return false;
                }

                if (el.customDataTag === undefined) {
                    return false;
                }

                return (window.ElementDataStore[el.customDataTag] && window.ElementDataStore[el.customDataTag][name]) ? true : false;
            },

            remove(name) {
                if (el && this.has(name)) {
                    delete window.ElementDataStore[el.customDataTag][name];
                }
            }
        }
    }

    parseJson(value) {
        if (typeof value === 'string') {
            value = value.replace(/'/g, "\"");

            var jsonStr = value.replace(/(\w+:)|(\w+ :)/g, function (matched) {
                return '"' + matched.substring(0, matched.length - 1) + '":';
            });

            try {
                value = JSON.parse(jsonStr);
            } catch (e) { }
        }

        return value;
    }

    getResponsiveValue(value) {
        var width = this.getViewPort().width;
        var result;

        value = this.parseJson(value);

        if (typeof value === 'object') {
            var resultKey;
            var resultBreakpoint = -1;
            var breakpoint;

            for (var key in value) {
                if (key === 'default') {
                    breakpoint = 0;
                } else {
                    breakpoint = this.getBreakpoint(key) ? this.getBreakpoint(key) : parseInt(key);
                }

                if (breakpoint <= width && breakpoint > resultBreakpoint) {
                    resultKey = key;
                    resultBreakpoint = breakpoint;
                }
            }

            if (resultKey) {
                result = value[resultKey];
            } else {
                result = value;
            }
        } else {
            result = value;
        }

        return result;
    }

    deepExtend(out) {
        out = out || {};

        for (var i = 1; i < arguments.length; i++) {
            var obj = arguments[i];
            if (!obj) continue;

            for (var key in obj) {
                if (!obj.hasOwnProperty(key)) {
                    continue;
                }

                if (Object.prototype.toString.call(obj[key]) === '[object Object]') {
                    out[key] = KTUtil.deepExtend(out[key], obj[key]);
                    continue;
                }

                out[key] = obj[key];
            }
        }

        return out;
    }

    snakeToCamel(s) {
        return s.replace(/(\-\w)/g, function(m){return m[1].toUpperCase();});
    }

    css(el, styleProp, value, important) {
        if(!el) {
            return;
        }

        if(value !== undefined) {
            if(!important == true) {
                el.style.setProperty(styleProp, value, 'important');
            } else {
                el.style[styleProp] = value;
            }
        } else {
            let defaultView = (el.ownerDocument || document).defaultView;
            if (defaultView && defaultView.getComputedStyle) {
                styleProp = styleProp.replace(/([A-Z])/g, "-$1").toLowerCase();

                return defaultView.getComputedStyle(el, null).getPropertyValue(styleProp);
            } else if (el.currentStyle) { 
                styleProp = styleProp.replace(/\-(\w)/g, function(str, letter) {
                    return letter.toUpperCase();
                });
                value = el.currentStyle[styleProp];
                if (/^\d+(em|pt|%|ex)?$/i.test(value)) {
                    return (function(value) {
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
    }

    visible(el) {
        return !(el.offsetWidth === 0 && el.offsetHeight === 0);
    }

    throttle(timers, fun, delay) {
        if (timers) {
            return;
        }

        timers  =  setTimeout(function () {
            fun();
            timers  =  undefined;
        }, delay);
    }




}
