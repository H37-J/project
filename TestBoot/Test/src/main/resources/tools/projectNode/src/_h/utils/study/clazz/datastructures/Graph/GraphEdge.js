
export default class GraphEdge {
    constructor(startVertex, endVertex, weight = 0) {
        this.startVertex = startVertex
        this.endVertex = endVertex
        this.weight = weight
    }

    getKey() {
        const startVertexKey = this.startVertex.getKey()
        const endVertexKey = this.endVertex.getKey()

        return `${startVertexKey}_${endVertexKey}`
    }

    reverse() {
        const temp = this.startVertex
        this.startVertex = this.endVertex
        this.endVertex = temp
        return this
    }

    toString() {
        return this.getKey()
    }
}