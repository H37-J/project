const getImages = (el, includeDuplicated = false) => {
    const images = [...el.getElementsByTagName('img')].map(img =>
        img.getAttribute('src')
    );
    return includeDuplicated ? images : [...new Set(images)];
}