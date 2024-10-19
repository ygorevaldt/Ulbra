public class CancelledOrdersStack extends LinkedList {
    public CancelledOrdersStack() {
        this.start = null;
    }

    public void push(Order value) {
        this.size++;
        Node<Order> newValue = new Node<>(value);
        newValue.setNext(this.start);
        this.start = newValue;
    }

    public Order pop() {
        if (this.start == null) {
            System.out.println("Empty stack");
            return null;
        }
        Order cancelledOrder = this.start.getValue();
        this.start = this.start.getNext();
        this.size--;

        return cancelledOrder;
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
