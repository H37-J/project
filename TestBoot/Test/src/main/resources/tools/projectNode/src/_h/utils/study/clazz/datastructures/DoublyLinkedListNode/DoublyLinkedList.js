import Comparator from "../../comparator/Comparator"
import DoublyLinkedListNode from "./DoublyLinkedListNode"

export default class DoublyLinkedList {
    constructor(compareFunction) {
        this.head = null
        this.tail = null
        this.comapre = new Comparator(compareFunction)
    }

    prepend(value) {
        const newNode = new DoublyLinkedListNode(value, this.head)
        if(this.head) {
            this.head.previous = newNode
        }
        this.head = newNode

        if(!this.tail) {
            this.tail = newNode
        }
        return this
    }

}