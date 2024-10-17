public class PendingOrderList {
    private Node<Order> start;
    private int size = 0;

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

    public void dequeue() {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }
        this.start = this.start.getNext();
        this.size--;
    }

    public void dequeueBy(String id) {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }

        if (this.start.getValue().getId().toString().equals(id)) {
            this.start = this.start.getNext();
            this.size--;
            return;
        }

        Node<Order> currentNode = this.start;
        Node<Order> previousNode = null;

        while (currentNode != null && !currentNode.getValue().getId().toString().equals(id)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            System.out.println("Pedido " + id + " não encontrado");
            return;
        }

        previousNode.setNext(currentNode.getNext());
        this.size--;
    }

    public Order getById(String id) {
        if (this.start == null) {
            System.out.println("Empty list");
            return null;
        }

        if (this.start.getValue().getId().toString().equals(id)) {
            return this.start.getValue();
        }

        Node<Order> currentNode = this.start;
        Node<Order> previousNode = null;

        while (currentNode != null && !currentNode.getValue().getId().toString().equals(id)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            System.out.println(String.format("Pedido '%s' não encontrado", id));
            return null;
        }

        return currentNode.getValue();
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

    public int getSize() {
        return size;
    }
}
