const getImages = el => {
    const images = [...el.getElementsByTagName('img')].map(img => {
        img.getAttribute('src');
    });
    return images;
};

getImages(document);