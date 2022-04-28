const haveSameContent = (a, b) => {
  for (const v in new Set([...a, ...b])) {
    console.log(v);
  }
};

haveSameContent([1,2,3],[4,5,6]);