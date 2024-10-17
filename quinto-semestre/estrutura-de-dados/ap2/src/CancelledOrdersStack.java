import java.util.UUID;

public class CancelledOrdersStack {
    private Node<Order> start;
    private int size = 0;

    public CancelledOrdersStack() {
        this.start = null;
    }

    public void push(Order value) {
        this.size++;
        Node<Order> newValue = new Node<>(value);

        if (this.start == null) {
            this.start = newValue;
            return;
        }

        Node<Order> currentNode = this.start;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(newValue);
    }

    public void pop() {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }
        this.start = this.start.getNext();
        this.size--;
    }

    public void pop(UUID id) {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }

        if (this.start.getValue().getId().equals(id)) {
            this.start = this.start.getNext();
            this.size--;
            return;
        }

        Node<Order> currentNode = this.start;
        Node<Order> previousNode = null;

        while (currentNode != null && !currentNode.getValue().getId().equals(id)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            System.out.println("Order with ID " + id + " not found.");
            return;
        }

        previousNode.setNext(currentNode.getNext());
        this.size--;
    }

    public String printStack() {
        if (this.start == null) {
            return "";
        }

        Node<Order> currentNode = this.start;
        String listAsText = "";
        while (currentNode != null) {
            listAsText += currentNode.getValue() + " ";
            currentNode = currentNode.getNext();
        }
        return listAsText;
    }

}
