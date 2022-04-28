const queryStringToObject = url =>
  [...new URLSearchParams(url.split('?')[1])].reduce((a, [k, v]) => ((a[k] = v), a), {});
