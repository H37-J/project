const indexOfString = (str, searchValue) => {
    const res = []
    let index = 0
    while(index < str.length) {
        const find = str.indexOf(searchValue, index)
        if(res !== -1) {
            res.push(find)
            index += find + 1
        } else {
            break
        }
    }
    console.log(res)}

indexOfString('taaaestes', 'es')