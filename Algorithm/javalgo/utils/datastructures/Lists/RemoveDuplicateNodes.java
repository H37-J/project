package datastructures.Lists;

public class RemoveDuplicateNodes {
    
    public Node deleteDuplicates(Node head){
        Node sentinel=new Node(0,head);

        Node pred= sentinel;

        while(head != null){
            if(head.next!=null && head.value==head.next.value){
                while(head.next!=null && head.value==head.next.value){
                    head=head.next;
                }
                pred.next=head.next;
            }else{
                pred=pred.next;
            }
            head=head.next;
        }
        return sentinel.next;
    }

    public void print(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            System.out.println(temp.value + "->");
            temp = temp.next;
        }
        if(temp != null){
            System.out.print(temp.value);
        }
    }
}
