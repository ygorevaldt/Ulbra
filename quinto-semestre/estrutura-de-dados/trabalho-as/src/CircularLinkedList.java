public class CircularLinkedList<T> {
    private Node<T> start;

    public CircularLinkedList(Node<T> start) {
        this.start = null;
    }

    public Node<T> getStart() {
        return this.start;
    }

    public void insertAtStart(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.start == null) {
            this.start = newNode;
            newNode.setNext(newNode);
            return;
        }

        newNode.setNext(this.start);
        Node<T> last = this.start;

        while (last.getNext() != this.start) {
            last = last.getNext();
        }

        last.setNext(newNode);
        this.start = newNode;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.start == null) {
            this.start = newNode;
            newNode.setNext(newNode);
            return;
        }

        Node<T> current = this.start;
        while (current.getNext() != this.start) {
            current = current.getNext();
        }

        current.setNext(newNode);
        newNode.setNext(this.start);
    }

    public void removeAtStart() {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }

        if (this.start.getNext() == this.start) {
            this.start = null;
            return;
        }

        Node<T> current = this.start;

        while (current.getNext() != this.start) {
            current = current.getNext();
        }

        this.start = this.start.getNext();
        current.setNext(this.start);
    }

    public void removeAtEnd() {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }

        if (this.start.getNext() == this.start) {
            this.start = null;
            return;
        }

        Node<T> current = this.start;
        Node<T> previous = null;

        while (current.getNext() != this.start) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(this.start);
    }

    public void print() {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }

        Node<T> current = this.start;

        do {
            System.out.println(current.getData() + " ");
            current = current.getNext();
        } while (current != this.start);
        System.out.println();
    }
}
