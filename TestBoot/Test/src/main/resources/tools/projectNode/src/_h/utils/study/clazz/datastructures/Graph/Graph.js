
export default class Graph {
  
    constructor(isDirected = false) {
        this.vertices = {}
        this.edges = {}
        this.isDirected = isDirected
    }

    addVertex(newVertex) {
        this.vertices[newVertex.getKey()] = newVertex
        return this
    }

    getVertexKey(vertexKey) {
        return this.vertices[vertexKey];
    }

    getNeighbors(vertex) {
        return vertex.getNeighbors()
    }

    getAllVerticies() {
        return Object.values(this.vertices)
    }

    getAllEdges() {
        return Object.values(this.edges)
    }

 
}