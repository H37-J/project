const addEventListenerAll = (targets, type, listener, options, useCapture) => {
    targets.forEach(target => {
        target.addEvetnListener(type, listener, options, useCapture);
    });
}

