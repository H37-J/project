export const bubbleSort = arr => {
    let swapped = false;
    const a = [...arr];
    for (let i = 1; i < a.length; i++){
        swapped = false;
        for(let j = 0; j < a.length - i; j++) {
            if(arr[j+1] < a[j]){
                [a[j], a[j+1]] = [a[j+1], a[j]];
                swapped=true;
            }
        }
        if(!swapped) return a;
    }
    return a;
};

const bucketSort = (arr, size = 5) => {
    const min = Math.min(...arr);
    const max = Math.max(...arr);
    const bucket = Array.from({length: Math.floor((max - min) / size) + 1}, () => []);
    arr.foreach(val => {
        bucket[Math.floor((val - min) / size).push(val)];
    });
    return bucket.reduce((acc, b) => [...acc, ...b.sort((a, b) => a - b)], [])
};

export const heapsort = arr => {
    const a = [...arr];
    let l = a.length;

    const heapify = (a, i) => {
        const left = 2 * i + 1;
        const right = 2 * i + 2;
        let max = i;
        if(left < l && a[left] > a[max]) max = left;
        if(right < l && a[right] > a[max]) max = right;
        if(max != i) {
            [a[max], a[i]] = [a[i], a[max]];
            heapify(a, max);
        }
    }

    for(let i = Math.floor(l / 2); i >= 0; i--) heapify(a, i);

    return a;
};

const insertionSort = arr => {
    arr.reduce((acc, x) => {
        if(!acc.length) return [x];
        acc.some((y, j) => {
            if(x <= y) {
                acc.splice(j, 0, x);
                return true;
            }
            if(x > y && j === acc.length - 1){
                acc.splice(j + 1, 0, x);
                return true;
            }
            return false;
        });
        return acc;
    },[]);
};

const selectionSort = arr => {
    const a = [...arr];
    for (let i = 0; i < a.length; i++) {
      const min = a
        .slice(i + 1)
        .reduce((acc, val, j) => (val < a[acc] ? j + i + 1 : acc), i);
      if (min !== i) [a[i], a[min]] = [a[min], a[i]];
    }
    return a;
  };