/**
 * Slider wrapper.
 *
 * @author Htmlstream
 * @version 1.0
 *
 */
;
(function($) {
    'use strict';

    $.HSCore.components.HSSlider = {
        /**
         *
         *
         * @var Object _baseConfig
         */
        _baseConfig: {
            dateFormat: 'dd.mm.yy',
            prevText: '<i class="fa fa-angle-left"></i>',
            nextText: '<i class="fa fa-angle-right"></i>'
        },

        /**
         *
         *
         * @var jQuery pageCollection
         */
        pageCollection: $(),

        /**
         * Initialization of Slider wrapper.
         *
         * @param String selector (optional)
         * @param Object config (optional)
         *
         * @return jQuery pageCollection - collection of initialized items.
         */

        init: function(selector, config) {

            this.collection = selector && $(selector).length ? $(selector) : $();
            if (!$(selector).length) return;

            this.config = config && $.isPlainObject(config) ?
                $.extend({}, this._baseConfig, config) : this._baseConfig;

            this.config.itemSelector = selector;

            this.initSlider();

            return this.pageCollection;

        },

        initSlider: function() {
            //Variables
            var $self = this,
                config = $self.config,
                collection = $self.pageCollection;

            //Actions
            this.collection.each(function(i, el) {
                //Variables
                var $this = $(el),
                    $resultContainer = $this.data('result-container'),
                    rangeBoolean = $this.data('range'),
                    minVal = $this.data('min'),
                    maxVal = $this.data('max'),
                    defaultVal = $this.data('default'),
                    step = $this.data('step');
                document.getElementById('pmin').value = minVal;
                document.getElementById('pmax').value = maxVal;
                $this.slider({
                    range: rangeBoolean == 1 ? true : 'min',
                    min: minVal,
                    max: maxVal,
                    step: step ? step : 1,
                    values: rangeBoolean == 1 ? JSON.parse('[' + defaultVal + ']') : false,
                    value: defaultVal ? defaultVal : false,
                    slide: function(event, ui) {
                        if (rangeBoolean == 1) {
                            $('#' + $resultContainer).text(`${ui.values[0]}원-${ui.values[1]}원`);
                            document.getElementById('pmin').value = ui.values[0];
                            document.getElementById('pmax').value = ui.values[1];
                            //비동기 가격 필터
                            const cm = document.getElementById('cm').textContent;
                            const cs = document.getElementById('cs').textContent;
                            let size = document.getElementById('checkbox_size').value;
                            var header = $("meta[name='_csrf_header']").attr("content");
                            var token  = $("meta[name='_csrf']").attr("content");
                            
                            $.ajax({
                                "url": "/asynFilterPrice",
                                "method": "post",
                                "data": {
                                    "field": 'price',
                                    "priceMin": ui.values[0],
                                    "priceMax": ui.values[1],
                                    "cm": cm,
                                    "cs": cs,
                                    "size": size,
                                },
                                beforeSend	: function(xhr) {
                                    xhr.setRequestHeader(header, token);
                                },
                                error: function(error) {

                                }
                            }).done(function(response) {
                                if (typeof response.message != 'undefined') {

                                } else {
                                    $('#pFilter').replaceWith(response);
                                }
                            });

                        } else {
                            $('#' + $resultContainer).text(ui.value);
                        }
                    }
                });

                if (rangeBoolean == 1) {
                    $('#' + $resultContainer).text($this.slider('values', 0) + ' - ' + $this.slider('values', 1));
                }

                //Actions
                collection = collection.add($this);
            });
        }

    };

})(jQuery);