package search;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

public class DepthFirstSearch {
    
    static class Node {
        private final String name;
        private final List<Node> subNodes;

        public Node(final String name){
            this.name = name;
            this.subNodes = new ArrayList<>();
        }

        public Node(final String name, final List<Node> subNodes){
            this.name = name;
            this.subNodes = subNodes;
        }

        public String getName(){
            return name;
        }

        public List<Node> getSubNodes(){
            return subNodes;
        }
    }

    public static Optional<Node> search(final Node node, final String name){
        System.out.println(node.name);
        if(node.getName().equals(name)){
            return Optional.of(node);
        }

        return node.getSubNodes()
            .stream()
            .map(value -> search(value, name))
            .flatMap(Optional::stream)
            .findAny();
    }

    public static Optional<Node> searcBreadFirst(final Node node, final String name) {

        if (node.getName().equals(name)) {
            return Optional.of(node);
        }

        List<Node> queue = new ArrayList<>(node.getSubNodes());
        queue.stream().forEach(e -> System.out.println(e.name));

        while (!queue.isEmpty()) {
            final Node current = queue.get(0);

            if (current.getName().equals(name)) {
                return Optional.of(current);
            }

            queue.addAll(current.getSubNodes());

            queue.remove(0);
        }

        return Optional.empty();
    }

    public static void main(final String[] args){
        final Node rootNode = new Node("A", List.of(
                new Node("B", List.of(new Node("D"), new Node("F", List.of(
                        new Node("H"), new Node("I")
                )))),
                new Node("C", List.of(new Node("G"))),
                new Node("E")
        ));

        {
            final String expected = "I";

            final Node result = searcBreadFirst(rootNode, expected)
                    .orElseThrow(() -> new AssertionError("Node not found!"));


        }
    }

   
}
