package datastructures.stack;

import org.w3c.dom.Node;

public class NodeStack<Item> {

    private Item data;
    private static NodeStack<?> head;
    private NodeStack<?> next;
    private NodeStack<?> previous;
    private static int size=0;

    public NodeStack(){}

    private NodeStack(Item item){
        this.data=item;
    }

    public void push(Item item){
        NodeStack<Item> newNs=new NodeStack<Item>(item);

        if(this.isEmpty()){
            NodeStack.setHead(new NodeStack<>(item));
            newNs.setNext(null);
            newNs.setPrevious(null);
        }else{
            newNs.setPrevious(NodeStack.head);
            NodeStack.head.setNext(newNs);
            NodeStack.head.setHead(newNs);
        }

        NodeStack.setSize(NodeStack.getSize() + 1);
    }

    public Item pop(){
        Item item = (Item) NodeStack.head.getData();

        NodeStack.head.setHead(NodeStack.head.getPrevious());
        NodeStack.head.setNext(null);

        NodeStack.setSize(NodeStack.getSize() - 1);

        return item;
    }

    public Item peek(){
        return (Item) NodeStack.head.getData();
    }

    public boolean isEmpty(){
        return NodeStack.getSize()==0;
    }

    public int size(){
        return NodeStack.getSize();
    }

    public void print(){
        for(NodeStack<?> n=NodeStack.head; n!=null; n=n.previous){
            System.out.println(n.getData().toString());
        }
    }

    private NodeStack<?> getHead(){
        return NodeStack.head;
    }

    private static void setHead(NodeStack<?> ns){
        NodeStack.head=ns;
    }

    private NodeStack<?> getNext(){
        return next;
    }
    
    private void setNext(NodeStack<?> next){
        this.next=next;
    }

    private NodeStack<?> getPrevious(){
        return previous;
    }

    private void setPrevious(NodeStack<?> previous) {
        this.previous = previous;
      }
    
      private static int getSize() {
        return size;
      }
    
      private static void setSize(int size) {
        NodeStack.size = size;
      }

      private Item getData(){
          return this.data;
      }

      private void setData(Item item){
          this.data=item;
      }


   
  public static void main(String[] args) {
    NodeStack<Integer> Stack = new NodeStack<Integer>();

    Stack.push(3);
    Stack.push(4);
    Stack.push(5);
    System.out.println("Testing :");
    Stack.print(); // prints : 5 4 3

    Integer x = Stack.pop(); // x = 5
    Stack.push(1);
    Stack.push(8);
    Integer y = Stack.peek(); // y = 8
    System.out.println("Testing :");
    Stack.print(); // prints : 8 1 4 3

    System.out.println("Testing :");
    System.out.println("x : " + x);
    System.out.println("y : " + y);
  }
}
