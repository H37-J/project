"use strict";

var MEMCHART = (function () {
    var initChart = function () {
        var el = document.getElementById("memorychart");

        if (!el) {
            return;
        }

        var options = {
            size: el.getAttribute("data-kt-size")
                ? parseInt(el.getAttribute("data-kt-size"))
                : 70,
            lineWidth: el.getAttribute("data-kt-line")
                ? parseInt(el.getAttribute("data-kt-line"))
                : 11,
            rotate: el.getAttribute("data-kt-rotate")
                ? parseInt(el.getAttribute("data-kt-rotate"))
                : 195,
        };

        var canvas = document.createElement("canvas");
        var span = document.createElement("span");

        if (typeof G_vmlCanvasManager !== "undefined") {
            G_vmlCanvasManager.initElement(canvas);
        }

        var ctx = canvas.getContext("2d");
        canvas.width = canvas.height = options.size;

        el.appendChild(span);
        el.appendChild(canvas);

        ctx.translate(options.size / 2, options.size / 2);
        ctx.rotate((-1 / 2 + options.rotate / 180) * Math.PI);

        var radius = (options.size - options.lineWidth) / 2;

        var drawCircle = function (color, lineWidth, percent) {
            percent = Math.min(Math.max(0, percent || 1), 1);
            ctx.beginPath();
            ctx.arc(0, 0, radius, 0, Math.PI * 2 * percent, false);
            ctx.strokeStyle = color;
            ctx.lineCap = "round"; // butt, round or square
            ctx.lineWidth = lineWidth;
            ctx.stroke();
        };

        drawCircle("#E4E6EF", options.lineWidth, 100 / 100);
        drawCircle(
            KTUtil.getCssVariableValue("--bs-primary"),
            options.lineWidth,
            150 / 150
        );
    
    };

    return {
        init: function () {
            initChart();
        },
    };
})();

if (typeof module !== "undefined") {
    module.exports = MEMCHART;
}

KTUtil.onDOMContentLoaded(function () {
    MEMCHART.init();
});

var CPUCHART = (function () {
    var initChart = function () {
        var el = document.getElementById("cpuchart");

        if (!el) {
            return;
        }

        var options = {
            size: el.getAttribute("data-kt-size")
                ? parseInt(el.getAttribute("data-kt-size"))
                : 70,
            lineWidth: el.getAttribute("data-kt-line")
                ? parseInt(el.getAttribute("data-kt-line"))
                : 11,
            rotate: el.getAttribute("data-kt-rotate")
                ? parseInt(el.getAttribute("data-kt-rotate"))
                : 145,
        };

        var canvas = document.createElement("canvas");
        var span = document.createElement("span");

        if (typeof G_vmlCanvasManager !== "undefined") {
            G_vmlCanvasManager.initElement(canvas);
        }

        var ctx = canvas.getContext("2d");
        canvas.width = canvas.height = options.size;

        el.appendChild(span);
        el.appendChild(canvas);

        ctx.translate(options.size / 2, options.size / 2);
        ctx.rotate((-1 / 2 + options.rotate / 180) * Math.PI);

        var radius = (options.size - options.lineWidth) / 2;

        var drawCircle = function (color, lineWidth, percent) {
            percent = Math.min(Math.max(0, percent || 1), 1);
            ctx.beginPath();
            ctx.arc(0, 0, radius, 0, Math.PI * 2 * percent, false);
            ctx.strokeStyle = color;
            ctx.lineCap = "round"; // butt, round or square
            ctx.lineWidth = lineWidth;
            ctx.stroke();
        };

        drawCircle("#E4E6EF", options.lineWidth, 100 / 100);
        drawCircle(
            KTUtil.getCssVariableValue("--bs-primary"),
            options.lineWidth,
            100 / 150
        );
        drawCircle(
            KTUtil.getCssVariableValue("--bs-success"),
            options.lineWidth,
            100 / 250
        );
    };

    return {
        init: function () {
            initChart();
        },
    };
})();

if (typeof module !== "undefined") {
    module.exports = CPUCHART;
}

KTUtil.onDOMContentLoaded(function () {
    CPUCHART.init();
});



var DISKCHART = (function () {
    var initChart = function () {
        var el = document.getElementById("diskchart");

        if (!el) {
            return;
        }

        var options = {
            size: el.getAttribute("data-kt-size")
                ? parseInt(el.getAttribute("data-kt-size"))
                : 70,
            lineWidth: el.getAttribute("data-kt-line")
                ? parseInt(el.getAttribute("data-kt-line"))
                : 11,
            rotate: el.getAttribute("data-kt-rotate")
                ? parseInt(el.getAttribute("data-kt-rotate"))
                : 145,
        };

        var canvas = document.createElement("canvas");
        var span = document.createElement("span");

        if (typeof G_vmlCanvasManager !== "undefined") {
            G_vmlCanvasManager.initElement(canvas);
        }

        var ctx = canvas.getContext("2d");
        canvas.width = canvas.height = options.size;

        el.appendChild(span);
        el.appendChild(canvas);

        ctx.translate(options.size / 2, options.size / 2);
        ctx.rotate((-1 / 2 + options.rotate / 180) * Math.PI);

        var radius = (options.size - options.lineWidth) / 2;

        var drawCircle = function (color, lineWidth, percent) {
            percent = Math.min(Math.max(0, percent || 1), 1);
            ctx.beginPath();
            ctx.arc(0, 0, radius, 0, Math.PI * 2 * percent, false);
            ctx.strokeStyle = color;
            ctx.lineCap = "round"; // butt, round or square
            ctx.lineWidth = lineWidth;
            ctx.stroke();
        };

        drawCircle("#E4E6EF", options.lineWidth, 100 / 100);
        drawCircle(
            KTUtil.getCssVariableValue("--bs-primary"),
            options.lineWidth,
            100 / 150
        );
        drawCircle(
            KTUtil.getCssVariableValue("--bs-success"),
            options.lineWidth,
            100 / 250
        );
    };

    return {
        init: function () {
            initChart();
        },
    };
})();

if (typeof module !== "undefined") {
    module.exports = DISKCHART;
}

KTUtil.onDOMContentLoaded(function () {
    DISKCHART.init();
});



var LOADCHART = (function () {
    var initChart = function () {
        var el = document.getElementById("loadchart");

        if (!el) {
            return;
        }

        var options = {
            size: el.getAttribute("data-kt-size")
                ? parseInt(el.getAttribute("data-kt-size"))
                : 70,
            lineWidth: el.getAttribute("data-kt-line")
                ? parseInt(el.getAttribute("data-kt-line"))
                : 11,
            rotate: el.getAttribute("data-kt-rotate")
                ? parseInt(el.getAttribute("data-kt-rotate"))
                : 145,
        };

        var canvas = document.createElement("canvas");
        var span = document.createElement("span");

        if (typeof G_vmlCanvasManager !== "undefined") {
            G_vmlCanvasManager.initElement(canvas);
        }

        var ctx = canvas.getContext("2d");
        canvas.width = canvas.height = options.size;

        el.appendChild(span);
        el.appendChild(canvas);

        ctx.translate(options.size / 2, options.size / 2);
        ctx.rotate((-1 / 2 + options.rotate / 180) * Math.PI);

        var radius = (options.size - options.lineWidth) / 2;

        var drawCircle = function (color, lineWidth, percent) {
            percent = Math.min(Math.max(0, percent || 1), 1);
            ctx.beginPath();
            ctx.arc(0, 0, radius, 0, Math.PI * 2 * percent, false);
            ctx.strokeStyle = color;
            ctx.lineCap = "round"; // butt, round or square
            ctx.lineWidth = lineWidth;
            ctx.stroke();
        };

        drawCircle("#E4E6EF", options.lineWidth, 100 / 100);
        drawCircle(
            KTUtil.getCssVariableValue("--bs-primary"),
            options.lineWidth,
            100 / 150
        );
        drawCircle(
            KTUtil.getCssVariableValue("--bs-success"),
            options.lineWidth,
            100 / 250
        );
    };

    return {
        init: function () {
            initChart();
        },
    };
})();

if (typeof module !== "undefined") {
    module.exports = LOADCHART;
}

KTUtil.onDOMContentLoaded(function () {
    LOADCHART.init();
});
