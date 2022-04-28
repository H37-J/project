const linearSearch = (arr, item) => {
    for(const i in arr){
        if(arr[i] === item) return +i;
    }
    return -1;
};