let chatText = document.querySelector('#chat_text');
let chatSend = document.querySelector('#chat_send');

let _send = (e) => {

    if(e.code === "Enter") {
        chatSend.click();
    }
}

let _click = () => {
    chatText.value = '';

    let div = document.get
}

chatText.addEventListener('keypress', _send);
chatSend.addEventListener('click', _click);
