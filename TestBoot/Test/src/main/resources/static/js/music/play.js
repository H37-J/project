import Utils from "../utils/utils.js";

let utils = new Utils();

var audio = document.querySelector('[data-element="audio-track-1"]');
var progress = document.querySelector('[data-element="progress"]');        
var currentTime = document.querySelector('[data-element="current-time"]');
var duration = document.querySelector('[data-element="duration"]');
var playButton = document.querySelector('[data-element="play-button"]');
var playIcon = document.querySelector('[data-element="play-icon"]');
var pauseIcon = document.querySelector('[data-element="pause-icon"]');

var replayButton = document.querySelector('[data-element="replay-button"]');
var shuffleButton = document.querySelector('[data-element="shuffle-button"]');
var playNextButton = document.querySelector('[data-element="play-next-button"]');
var playPrevButton = document.querySelector('[data-element="play-prev-button"]');

let formatTime = (time) => {
    let s = parseInt(time % 60);
    let m = parseInt((time / 60) % 60);
    return m + ":" + (s < 10 ? '0' : '') + s;
}

duration.innerHTML = formatTime(audio.duration);

let setBraProgress = () => {
    progress.value = (audio.currentTime / audio.duration) * 100;
    if(parseInt(progress.value) == 100) {
        audio.currentTime = 0;
        audio.play();
    }
}

let handleAudioUpdate = () => {
    currentTime.innerHTML = formatTime(audio.currentTime);
    setBraProgress();
}
setInterval(handleAudioUpdate,990);

playButton.addEventListener('click', function() {
    if(audio.duration > 0 && !audio.paused) {
        audio.pause();
        playIcon.classList.remove('d-none');
        pauseIcon.classList.add('d-none');
    } else if(audio.readyState >= 2) {
        audio.play();
        playIcon.classList.add('d-none');
        pauseIcon.classList.remove('d-none');
    }
});

replayButton.addEventListener('click', function() {
    if(audio.readyState >= 2) {
        audio.currentTime = 0;
        audio.play();

        playIcon.classList.add('d-none');
        pauseIcon.classList.remove('d-none');
    }
});

playNextButton.addEventListener('click', function() {
    if (audio.readyState >= 2) {
        audio.currentTime = 0;
        audio.play();

        playIcon.classList.add('d-none');
        pauseIcon.classList.remove('d-none');
    }
});

shuffleButton.addEventListener('click', function() {
    if (audio.readyState >= 2) {
        audio.currentTime = 0;
        audio.play();

        playIcon.classList.add('d-none');
        pauseIcon.classList.remove('d-none');
    }
});

progress.addEventListener('change', function() {
    audio.currentTime = ((audio.duration * progress.value / 100))
});

