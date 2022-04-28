"use strict";
import Utils from "../utils/utils.js";

let utils = new Utils();

window.onload = function () {
    utils.on(
        document.body,
        '[data-kt-element="list-play-button"]',
        "click",
        function (e) {
            console.log("tests");
        }
    );
};
