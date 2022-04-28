import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class studytwo {

    public static void main(String[] args) {
        Graphs<Integer> graphs = new Graphs<Integer>();
        graphs.add(1, 2);
        graphs.add(2, 3);
        graphs.add(4, 5);
        graphs.depthSearch();

    }

}

class Graphs<E extends Comparable<E>> {

    class Node {
        E data;

        public Node(E data) {
            this.data = data;
        }
    }

    class Edge {
        Node startNode, endNode;

        public Edge(Node startNode, Node endNode) {
            this.startNode = startNode;
            this.endNode = endNode;
        }
    }

    ArrayList<Node> NodeList;
    ArrayList<Edge> EdgeList;

    public Graphs() {
        NodeList = new ArrayList<>();
        EdgeList = new ArrayList<>();
    }

    public void add(E startNode, E endNode) {
        Node start = null, end = null;
        for (Node node : NodeList) {
            if (startNode.compareTo(node.data) == 0) {
                start = node;
            } else if (endNode.compareTo(node.data) == 0) {
                end = node;
            }
        }
        if (start == null) {
            start = new Node(startNode);
            NodeList.add(start);
        }
        if (end == null) {
            end = new Node(endNode);
            NodeList.add(end);
        }
        EdgeList.add(new Edge(start, end));
    }

    public void printNode() {
        NodeList.stream().forEach(e -> System.out.println(e.data));
    }

    public void printEdge() {
        EdgeList.stream().forEach(e -> System.out.println(e.startNode.data + "," + e.endNode.data));
    }

    public void NodeSize() {
        System.out.println(NodeList.size());
    }

    public void EdgeSize() {
        System.out.println(EdgeList.size());
    }

    public Node getStartNode() {
        return this.NodeList.get(0);
    }

    public void depthSearch() {
        Set<Node> markedNodes = new HashSet<Node>();

        for (Node n : NodeList) {
            if (!markedNodes.contains(n)) {
                markedNodes.add(n);
                markedNodes.addAll(depthFirstSearch(n, new ArrayList<Node>()));
            }
        }

        markedNodes.stream().forEach(e -> System.out.println(e.data));
    }

    public ArrayList<Node> depthFirstSearch(Node n, ArrayList<Node> visited) {
        visited.add(n);

        for (Edge e : EdgeList) {
            if (e.startNode.equals(n) && !visited.contains(e.endNode)) {
                depthFirstSearch(e.endNode, visited);
            }
        }
        return visited;
    }
}
