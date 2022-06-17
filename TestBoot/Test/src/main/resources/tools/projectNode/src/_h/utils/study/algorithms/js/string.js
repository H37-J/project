
export const getFileExtension = (str) => {
    const arr = str.split('.');
    return arr[arr.length - 1];
}
