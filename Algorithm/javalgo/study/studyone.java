import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class studyone {

    public static void main(String[] args) {
        NodeList nodeList = new NodeList();
        nodeList.push("data1");
        nodeList.push("data0");
        String result = nodeList.search("data12");

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("test1",13));
        list.add(new Person("test2",14));
        //list.stream().map(Person::getName).forEach(e -> System.out.println(e));

        List<Person> queue = new ArrayList<>(list);

        Node node = new Node("data1");
        //System.out.println(Optional.of(node).get().getData());


        
    }

}

class NodeList {
    Node head;

    public NodeList() {
        head = null;
    }

    public String search(String data){
        Node cur = head;
        if(head.data.equals(data)) return head.data;
        while(cur.next != null){
            if(cur.next.data.equals(data)) return cur.next.data;
            cur = cur.next;
        }
        return null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    public void pushNth(String data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newNode = cur.next;
        cur.next = newNode;
    }

    public void removeNth(int index){
        Node cur = head;
        for(int i = 0; i < index - 1; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        return;
    }

    public Node getHead() {
        return this.head;
    }
}

class Node {
    String data;
    Node next;

    public Node() {

    }

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }
}



class Person {
    String name;
    int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}