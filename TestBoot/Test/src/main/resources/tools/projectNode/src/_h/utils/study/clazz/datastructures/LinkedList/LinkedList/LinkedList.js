import Comparator from "../../../comparator/Comparator.js"
import LinkedListNode from "./LinkedListNode.js"

export default class LinkedList {
    constructor(compareFunction) {
        this.head = null
        this.tail = null
        this.compare = new Comparator(compareFunction)
    }

    prepend(value) {
        const newNode = new LinkedListNode(value, this.head)
        this.head = newNode


        if (!this.tail) {
            this.tail = newNode
        }

        return this
    }

    append(value) {
        const newNode = new LinkedListNode(value)

        if (!this.head) {
            this.head = newNode
            this.tail = newNode
            return this
        }

        this.tail.next = newNode
        this.tail = newNode

        return this
    }

    insert(value, index) {
        index = index < 0 ? 0 : index
        if (index === 0) {
            this.prepend(value)
        } else {
            let count = 0
            let currentNode = this.head
            const newNode = new LinkedListNode(value)
            while (currentNode) {
                if (count + 1 === index) break;
                currentNode = currentNode.next
                count += 1
            }
            if (currentNode) {
                newNode.next = currentNode.next
                currentNode.next = newNode
            } else {
                if (this.tail) {
                    this.tail.next = newNode
                    this.tail = newNode
                } else {
                    this.head = newNode
                    this.tail = newNode
                }
            }


        }
        return this
    }

    delete(value) {
        if (!this.head) {
            return null
        }

        let deletedNode = null

        while (this.head && this.compare.equal(this.head.value, value)) {
            deletedNode = this.head
            this.head = this.head.next
        }

        let currentNode = this.head

        if (currentNode !== null) {
            while (currentNode.next) {
                if (this.compare.equal(currentNode.next.value, value)) {
                    deletedNode = currentNode.next
                    currentNode.next = currentNode.next.next
                } else {
                    currentNode = currentNode.next
                }
            }
        }

        if(this.compare.equal(this.tail.value, value)) {
            this.tail = currentNode
        }
        return deletedNode
    }

    find({value = undefined, callback = undefined}) {
        if(!this.head) {
            return null
        }

        let currentNode = this.head

        while(currentNode) {
            if(callback && callback(currentNode.value)) {
                return currentNode
            }

            if(value !== undefined && this.compare.equal(currentNode.value, value)) {
                return currentNode
            }

            currentNode = currentNode.next
        }
        return null
    }

    deleteTail() {
        const deletedTail = this.tail

        if(this.head === this.tail) {
            this.head = null
            this.tail = null
            return deletedTail
        }

        let currentNode = this.head
        while(!currentNode.next) {
            if(!currentNode.next.next) {
                currentNode.next = null
            } else {
                currentNode = currentNode.next
            }
        }

        this.tail = currentNode

        return deletedTail
    }

    deleteHead() {
        if(!this.head) {
            return null
        }

        const deletedHead = this.head

        if(this.head.next) {
            this.head = this.head.next
        } else{
            this.head = null
            this.tail = null
        }
        return deletedHead
    }

    fromArray(values) {
        values.foreach((value) => this.append(value))

        return this
    }

    toArray() {
        const nodes = []
        let currentNode = this.head
        while(currentNode) {
            nodes.push(currentNode)
            currentNode = currentNode.next
        }
        return nodes
    }

    tosString(callback) {
        return this.toArray().map((node) => node.toString(callback)).toString()
    }

    reverse() {
        let currNode = this.head
        let prevNode = null
        let nextNode = null

        while(currNode) {
            nextNode = currNode.next
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode
        }
        this.tail = this.head
        this.head = prevNode
        return this
    }
}

const list = new LinkedList()
list.prepend(0)
list.prepend(2)
list.insert(1, 1)

console.log(list.head)