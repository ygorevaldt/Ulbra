public class LinkedList<T> {
    private Node<T> start;
    private int size = 0;

    public LinkedList() {
        this.start = null;
    }

    public void insert(T value) {
        this.size++;
        Node<T> newValue = new Node<>(value);

        if (this.start == null) {
            this.start = newValue;
            return;
        }

        Node<T> currentNode = this.start;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(newValue);
    }

    @Override
    public String toString() {
        if (this.start == null) {
            return "";
        }

        Node<T> currentNode = this.start;
        String listAsText = "";
        while (currentNode != null) {
            listAsText += currentNode.getValue() + " ";
            currentNode = currentNode.getNext();
        }
        return listAsText;
    }

    public void removeByValue(T value) {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }

        if (this.start.getValue().equals(value)) {
            this.start = this.start.getNext();
            return;
        }

        Node<T> currentNode = this.start;
        Node<T> previousNode = null;

        while (currentNode != null &&
                !currentNode.getValue().equals(value)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            System.out.println("Value is not found");
            return;
        }

        previousNode.setNext(currentNode.getNext());
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        // CONTINUAR DAQUI
    }

}
