package datastructures.Lists;

public class SearchSinglyLinkedListRecursion extends SinglyLinkedList {

    public static void main(String[] args) {
        SearchSinglyLinkedListRecursion list = new SearchSinglyLinkedListRecursion();
        for (int i = 1; i < 10; i++) {
            list.insert(i);
        }

        for (int i = 1; i <= 10; i++) {

        }
    }

    private boolean searchRecurseion(Node node, int key) {
        return node != null && (node.value == key || searchRecurseion(node.next, key));
    }

    @Override
    public boolean search(int key) {
        return searchRecurseion(getHead(), key);
    }

}
