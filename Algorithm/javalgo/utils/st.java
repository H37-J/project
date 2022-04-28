import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class st{

    public static void main(String[] args){
        final Node rootNode = new Node("A", List.of(
            new Node("B", List.of(new Node("D"), new Node("F", List.of(
                    new Node("H"), new Node("I")
            )))),
            new Node("C", List.of(new Node("G"))),
            new Node("E")
    ));
        String value = "C"; 
        
        search(rootNode, value);
    }

    public static Optional<Node> search(final Node node, final String name){
        if(node.getName().equals(name)){
            return Optional.of(node);
        }

        node.getSubNodes().stream().map(value -> search(value, name)).flatMap(Optional::stream).forEach(e -> System.out.println(e.getName()));

        return node.getSubNodes()
        .stream().map(value -> search(value, name))
        .flatMap(Optional::stream).findAny();
    }

    static class Node{
        String name;
        private final List<Node> subNodes;

        public Node(final String name){
            this.name = name;
            this.subNodes = new ArrayList<>();
        }

        public Node(final String name, final List<Node> subNodes) {
            this.name = name;
            this.subNodes = subNodes;
        }    

        public String getName(){
            return name;
        }

        public List<Node> getSubNodes() {
            return subNodes;
        }
    }


}
