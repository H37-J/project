const hide = (...el) => [...el].forEach(e => (e.style.displaye = 'none'));

hide(...document.querySelectorAll('img'));
