'use strict';

import Utils from "../utils/utils.js";

let utils = new Utils();

class Scroll {

    element;
    id;
    options;

    defaultOptions = {
        saveState: true
    };

    constructor(element, options) {
        this.element = element;
        this.id = element.getAttribute('id');
        this.options = utils.deepExtend({}, this.defaultOptions, options);
    }

    init() {
        if(!this.element){
            return;
        }

        this.element.setAttribute('data-scroll', 'true');
        this.update();
        utils.data(this.element).set('scroll', this)
    }

    update() {
        if(this.getOption('activate') === true || this.element.hasAttribute('data-scroll-activate') === false) {
            this.setHeight();
            this.setupStretchHeight();
            this.setupScrollHandler();
            this.setUpState();
        } else {
            this.resetHeight();
            this.destroyScrollHandler();
        }
    }

    destory() {
        utils.data(this.element).remove('scroll');
    }

    resetHeight() {
        utils.css(this.element, this.getHeightType(), '');
    }
    
    setHeight() {
        let heightType = this.getHeightType();
        let height = this.getHeight();

        if(height !== null && height.length > 0) {
            utils.css(this.element, heightType, height);
        } else {
            utils.css(this.element, heightType, '');
        }
    }

    setupStretchHeight() {
        let stretch = this.getOption('stretch');

        if(stretch !== null) {
            let elements = document.querySelectorAll(stretch);

            if(elements && elements.length == 2) {
                let element1 = elements[0];
                let element2 = elements[1]
                let diff = this.getElementHeight(element2) - this.getElementHeight(element1);

                if (diff > 0) {
                    var height = parseInt(utils.css(this.element, this.getHeightType())) + diff;

                    utils.css(this.element, this.getHeightType(), String(height) + 'px');
                }
            }
        }
    }

    setUpState() {
        if ( this.getOption('save-state') === true && typeof KTCookie !== 'undefined' && this.id ) {
            if ( utils.get(this.id + 'st') ) {
                var pos = parseInt(utils.get(this.id + 'st'));
                
                if ( pos > 0 ) {
                    this.element.scrollTop = pos;
                }
            }
        }
    }

    setupScrollHandler() {
        if ( this.getOption('save-state') === true && this.id ) {
            this.element.addEventListener('scroll', this.scrollHandler);
        } else {
            this.element.removeEventListener('scroll', this.scrollHandler);
        }
    }

    destroyScrollHandler() {
        this.element.removeEventListener('scroll', this.scrollHandler);
    }

    resetHeight() {
        utils.css(this.element, this.getHeightType(), '');
    }

    scrollHandler() {
        utils.set(this.id + 'st', this.element.scrollTop);
    }



    getHeight() {
        let height = this.getOption(this.getHeightType());

        if(height instanceof Function) {
            return height.call();
        } else if (height !== null && typeof height === 'string' && height.toLowerCase() === 'auto') {
            return this.getAutoHeight();
        } else {
            return height;
        }
    }

    getElementHeight(element) {
        var height = 0;

        if (element !== null) {
            height = height + parseInt(utils.css(element, 'height'));
            height = height + parseInt(utils.css(element, 'margin-top'));
            height = height + parseInt(utils.css(element, 'margin-bottom'));

            if (utils.css(element, 'border-top')) {
                height = height + parseInt(utils.css(element, 'border-top'));
            }

            if (utils.css(element, 'border-bottom')) {
                height = height + parseInt(utils.css(element, 'border-bottom'));
            }
        } 

        return height;
    }

    getAutoHeight() {
        let height = utils.getViewPort().height;
        let dependencies = this.getOption('dependencies');
        let wrappers = this.getOption('wrappers');
        let offset = this.getOption('offset');

        height = height - this.getElementSpacing(this.element); 

        if ( dependencies !== null ) {
            var elements = document.querySelectorAll(dependencies);

            if ( elements && elements.length > 0 ) {
                for ( var i = 0, len = elements.length; i < len; i++ ) {
                    if ( utils.visible(elements[i]) === false ) {
                        continue;
                    }

                    height = height - this.getElementHeight(elements[i]);
                }
            }
        }

        if ( wrappers !== null ) {
            var elements = document.querySelectorAll(wrappers);
            if ( elements && elements.length > 0 ) {
                for ( var i = 0, len = elements.length; i < len; i++ ) {
                    if ( utils.visible(elements[i]) === false ) {
                        continue;
                    }

                    height = height - this.getElementSpacing(elements[i]);
                }
            }
        }

        if ( offset !== null && typeof offset !== 'object') {
            height = height - parseInt(offset);
        }

        return String(height) + 'px';
    }

 

    getElementSpacing(element) {
        let spacing = 0;

        if (element !== null) {
            spacing = spacing + parseInt(utils.css(element, 'margin-top'));
            spacing = spacing + parseInt(utils.css(element, 'margin-bottom'));
            spacing = spacing + parseInt(utils.css(element, 'padding-top'));
            spacing = spacing + parseInt(utils.css(element, 'padding-bottom'));

            if (utils.css(element, 'border-top')) {
                spacing = spacing + parseInt(utils.css(element, 'border-top'));
            }

            if (utils.css(element, 'border-bottom')) {
                spacing = spacing + parseInt(utils.css(element, 'border-bottom'));
            }
        } 

        return spacing;
    }


    getOption(name) {
        if(this.element.hasAttribute('data-scroll-'+ name) === true) {
            let attr = this.element.getAttribute('data-scroll-' + name);
            let value = utils.getResponsiveValue(attr);

            if(value !== null && String(value) === 'true' ) {
                value = true;
            } else if( value !== null && String(value) === 'false') {
                value = false;
            }
            return value;
        } else {
            let optionName = utils.snakeToCamel(name);

            if(this.options[optionName]) {
                return utils.getResponsiveValue(this.options[optionName]);
            } else {
                return null;
            }
        }
    }

    getHeightType() {
        if (this.getOption('height')) {
            return 'height';
        } if (this.getOption('min-height')) {
            return 'min-height';
        } if (this.getOption('max-height')) {
            return 'max-height';
        }
    }

    static getInstance(element) {
        if ( element !== null && utils.data(element).has('scroll') ) {
            return utils.data(element).get('scroll');
        } else {
            return null;
        }
    }

    static createInstances(selector = '[data-scroll="true"]') { 
        let body = document.getElementsByTagName('body')[0];

        let elements = body.querySelectorAll(selector);
        if(elements && elements.length > 0) {
            for(let i = 0, len = elements.length; i < len; i++) {
                new this(elements[i]);
            }
        }
    }
}

window.addEventListener('resize', function() {
    let timer;
    let body = document.getElementsByTagName("body")[0];
    utils.throttle(timer, function() {
        var elements = body.querySelectorAll('[data-scroll="true"]');

        if ( elements && elements.length > 0 ) {
            for (let i = 0, len = elements.length; i < len; i++) {
                let scroll = Scroll.getInstance(elements[i]);
                if (scroll) {
                    scroll.update();
                }
            }
        }
    }, 200);
});

window.onload = function() {
    let elements = document.querySelectorAll('[data-scroll="true"]');
    if(elements && elements.length > 0) {
        for(let i = 0, len = elements.length; i < len; i++) {
            let scroll = new Scroll(elements[i]);
            if(scroll) {
                scroll.init();
            }
        }
    }
}