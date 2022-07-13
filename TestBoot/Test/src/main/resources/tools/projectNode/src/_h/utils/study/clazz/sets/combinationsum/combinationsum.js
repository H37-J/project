
function combinationSumRecursive(
    candiates,
    remaingSum,
    finalCombinations = [],
    currentCombination = [],
    start = 0
) {
    if (remaingSum < 0) {
        return finalCombinations
    }

    if (remaingSum === 0) {
        finalCombinations.push(currentCombination.slice())
        return finalCombinations
    }

    for (let index = start; index < candiates.length; index += 1) {
        const current = candiates[index]

        currentCombination.push(current)

        combinationSumRecursive(
            candiates,
            remaingSum - current,
            finalCombinations,
            currentCombination,
            index
        )

        currentCombination.pop()
    }
    console.log(finalCombinations)
    return finalCombinations
}

export default function combinationSum(candidates, target) {
    return combinationSumRecursive(candidates, target);
}

const arr = [1, 2, 3]
const target = 3
combinationSum(arr, target)