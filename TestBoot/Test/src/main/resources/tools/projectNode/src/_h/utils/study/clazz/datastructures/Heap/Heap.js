import Comparator from "../../comparator/Comparator.js"

export default class Heap {
    constructor(compareFunction) {
        if (new.target === Heap) {
            throw new TypeError('Cannot construct Heap instance directly')
        }

        this.heapContainer = []
        this.comapre = new Comparator(compareFunction)
    }

    getLeftChildIndex(parentIndex) {
        return (2 * parentIndex) + 1
    }

    getRightChildIndex(parentIndex) {
        return (2 * parentIndex) + 2
    }

    getParentIndex(childIndex) {
        return Math.floor((childIndex - 1) / 2)
    }

    hasparent(childIndex) {
        return this.getParentIndex(childIndex) >= 0
    }

    hasLeftChild(parentIndex) {
        return this.getLeftChildIndex(parentIndex) < this.heapContainer.length
    }

    hasRightChild(parentIndex) {
        return this.getRightChildIndex(parentIndex) < this.heapContainer.length
    }

    leftChild(parentIndex) {
        return this.heapContainr[this.getLeftChildIndex(parentIndex)]
    }

    rightChild(parentIndex) {
        return this.heapContainr[this.getRightChildIndex(parentIndex)]
    }

    parent(childIndex) {
        return this.heapContainer[this.getParentIndex(childIndex)]
    }

    peek() {
        if (this.heapContainer.length === 0) {
            return null
        }
        return this.heapContainer[0]
    }

    poll() {
        if (this.heapContainer.length === 0) {
            return null
        }

        if (this.heapContainer.length === 1) {
            return this.heapContainer.pop()
        }

        const item = this.heapContainer[0]
        this.heapContainer[0] = this.heapContainer.pop()
        this.heapifyDown()
        return item
    }

    add(item) {
        this.heapContainer.push(item)
        this.heapifyUp();
        return this
    }

    find(item, comparator = this.compare) {
        const foundItemIndices = []
        for (let itemIndex = 0; itemIndex < this.heapContainer.length; itemIndex += 1) {
            if (comparator.equal(item, this.heapContainer[itemIndex])) {
                foundItemIndices.push(itemIndex)
            }
        }
        return foundItemIndices
    }

    isEmpty() {
        return !this.heapContainer.length
    }

    toString() {
        return this.heapContainer.toString()
    }

    swap(indexOne, indexTwo) {
        const temp = this.heapContainer[indexTwo]
        this.heapContainer[indexTwo] = this.heapContainer[indexOne]
        this.heapContainer[indexOne] = temp
    }

    remove(item,comparator = this.compare) {
        const numberOfItemToRemove = this.find(item, comparator).length

        for(let iteration = 0; iteration < numberOfItemToRemove; iteration += 1) {
            const indexToRemove = this.find(item, comparator).pop()

            if(indexToRemove === (this.heapContainer.length - 1)) {
                this.heapContainer.pop()
            } else {
                this.heapContainer[indexToRemove] = this.heapContainer.pop()

                const parentItem = this.parent(indexToRemove)

                if(this.hasLeftChild(indexToRemove) && (
                    !parentItem
                    || this.pairIsInCorrectOrder(parentItem, this.heapContainer[indexToRemove])
                )) {
                    this.heapifyDown(indexToRemove) 
                } else {
                    this.heapifyUp(indexToRemove)
                }
            }
        }
    }

    heapifyUp(CustomStartIndex) {
        let currentIndex = CustomStartIndex || this.heapContainer.length - 1

        while (
            this.hasparent(currentIndex)
            && !this.pairIsInCorrectOrder(this.parent(currentIndex), this.heapContainer[currentIndex])
        ) {
            this.swap(currentIndex, this.getParentIndex(currentIndex))
            currentIndex = this.getParentIndex(currentIndex)
        }
    }

    heapifyDown(CustomStartIndex = 0) {
        let currentIndex = CustomStartIndex
        let nextIndex = null

        while(this.hasLeftChild(currentIndex)) {
            if(
                this.hasRightChild(currentIndex)
                && this.pairIsInCorrectOrder(this.rightChild(currentIndex), this.leftChild(currentIndex))
            ) {
                nextIndex = this.getRightChildIndex(currentIndex)
            } else {
                nextIndex = this.getLeftChildIndex(currentIndex)
            }

            if(this.pairIsInCorrectOrder(this.heapContainer[currentIndex], this.heapContainer[nextIndex])) {
                break;
            }

            this.swap(currentIndex, nextIndex)
            currentIndex = nextIndex
        }
    }

    pairIsInCorrectOrder(firstElement, secondElement) {
        throw new Error(`
          You have to implement heap pair comparision method
          for ${firstElement} and ${secondElement} values.
        `);
    }
}
