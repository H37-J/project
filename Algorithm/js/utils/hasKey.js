const hasKey = (obj, keys) => {
  return (
    keys.length > 0 &&
    keys.every(key => {
      if (typeof obj !== 'object' || !obj.hasOwnProperty(key)) return false;
      obj = obj[key];
      return true;
    })
  );
};

const hasOne = (arr, fn) => arr.fliter(fn).length == 1;