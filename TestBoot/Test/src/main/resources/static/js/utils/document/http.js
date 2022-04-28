const httpDelete = (url, callback, err = console.error) => {
    const request = new XMLHttpRequest();
    request.open("DELETE", url, true);
    request.onload = () => callback(request);
    request.onerror = () => err(request);
    request.send();
};

httpDelete('https://jsonplaceholder.typicode.com/posts/1', request => {
  console.log(request.responseText);
});

const httpGet = (url, callback, err = console.error) => {
    const request = new XMLHttpRequest();
    request.open('GET', url, true);
    request.onload = () => callback(request.responseText);
    request.onerror = () => err(request);
    request.send();
};

const httpPost = (url, data, callback, err = console.err) => {
    const request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.setRequestHeader('Content-type', 'application/json; charset=uft-8');
    request.onload = () => callback(request.responseText);
    request.onerror = () => err(request);
    request.send(data);
}

const newPost = {
    id: 'test',
    name: 'test2'
}

const data = JSON.stringify(newPost);
//httpPost('url', data, console.log);

const httpPut = (url, data, callback, err = console.error) => {
    const request = new XMLHttpRequest();
    request.open('PUT', url, true);
    request.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    request.onload = () => callback(request);
    request.onerror = () => err(request);
    request.send(data);
};
  
const httpsRedirect = () => {
    if(location.protocol !== 'https:') location.replace('https://' + location.href.split('//')[1]);
}