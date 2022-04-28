"use strict";

import Utils from "../../utils.js";

let utils = new Utils();

let fileElement = document.querySelector("input[type='file']");
let wrapperElement = document.querySelector(".image-input-wrapper");
let removeElement = document.querySelector("[data-image-input-action='remove']");
let reader = new FileReader();

let _change = (e) => {
    e.preventDefault();

    reader.readAsDataURL(fileElement.files[0]);
    reader.onload = function (e) {
        wrapperElement.src = e.target.result;
    }
}

let _remove = (e) => {
    e.preventDefault();
    wrapperElement.src = '/Test/src/main/resources/static/img/avatar.svg';
}

fileElement.addEventListener('change', _change);
removeElement.addEventListener('click', _remove);