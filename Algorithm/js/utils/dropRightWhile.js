const dropRightWhile = (arr,func) => {
    let rightIndex = arr.length;
    while(rightIndex -- && !func(arr[rightIndex]));
    return arr.slice(0,rightIndex);
};
