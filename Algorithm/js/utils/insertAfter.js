const insertAfter = (el, htmlString) => el.insertAdjacentHTML('afterend', htmlString);

insertAfter(document.getElementById('myId'), '<p>after</p>');
// <div id="myId">...</div> <p>after</p>

const insertBefore = (el, htmlString) => el.insertAdjacentHTML('beforebegin', htmlString);
