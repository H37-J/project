

import LinkedList from '../LinkedList/LinkedList/LinkedList';
export default class GraphVertex {

    constructor(value) {
        if (value === undefined) {
            throw new Error('Graph vertex mush have a value')
        }
        const edgeComparator = (edgeA, edgeB) => {
            if (edgeA.getKey() === edgeB.getKey()) {
                return 0
            }

            return edgeA.getKey() < edgeB.getKey() ? -1 : 1
        };

        this.value = value
        this.edges = new LinkedList(edgeComparator)
    }

  

}