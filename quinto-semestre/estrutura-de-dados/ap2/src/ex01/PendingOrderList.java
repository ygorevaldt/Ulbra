package ex01;

public class PendingOrderList extends LinkedList {
    public PendingOrderList() {
        this.start = null;
    }

    public void enqueue(Order value) {
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

    public Order dequeue() {
        if (this.start == null) {
            System.out.println("Empty list");
            return null;
        }

        Order start = this.start.getValue();

        this.start = this.start.getNext();
        this.size--;

        return start;
    }

    public Order getStart() {
        return this.start.getValue();
    }

    public String printQueue() {
        if (this.start == null) {
            return "";
        }

        Node<Order> currentNode = this.start;
        String listAsText = "";
        while (currentNode != null) {
            listAsText += currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return listAsText;
    }

    // public int getSize() {
    // return size;
    // }
}
