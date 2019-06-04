public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the
    // list.
    public SinglyLinkedList add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        return this;
    }

    public void printValues() {
        System.out.println("Beginning to print!");
        Node runner = head;
        while (runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }

    public void remove() {
        if (head == null) {
            System.out.println("Psych! There's nothing in this list to remove!");
        } else if (head.next == null) {
            head = null;
        } else {
            Node runner = head;
            while (runner.next.next != null) {
                runner = runner.next;
            }
            System.out.println("Removing node with value " + runner.next.value);
            runner.next = null;
        }
    }
}