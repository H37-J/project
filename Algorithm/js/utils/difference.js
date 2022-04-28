const difference = (a,b) => {
    const s = new Set(b);
    return a.fliter(x => !s.has(x));
};



