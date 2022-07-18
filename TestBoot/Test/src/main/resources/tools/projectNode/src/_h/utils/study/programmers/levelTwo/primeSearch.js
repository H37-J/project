const primeSearch = (numbers) => {
    numbers = [...numbers]
    console.log(numbers)

    const primeCheck = (number) => {
        if(number === 1 || number === 0) return false
        for(let i = 2; i <= Math.sqrt(number); i += 1) {
            if(number % i === 0) {
                return false
            }
        }
        return true
    }


   
    // let res = new Set()
    // numbers.forEach((value, index) => {
    //    const combos = numbers.slice(index + 1)
    //    console.log(combos)
    // })

    // return res.size
}

const numbers = "132"
primeSearch(numbers)