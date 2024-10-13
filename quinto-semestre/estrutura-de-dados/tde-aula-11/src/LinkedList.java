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

    public void insertAtStart(T value) {
        Node<T> newValue = new Node<>(value);

        if (this.start == null) {
            this.start = newValue;
        } else {
            newValue.setNext(this.start);
            this.start = newValue;
        }

        this.size++;
    }

    public void insertAtPosition(T value, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0) {
            insertAtStart(value);
            return;
        }

        Node<T> newValue = new Node<>(value);
        Node<T> currentNode = this.start;
        for (int i = 0; i < position - 1; i++) {
            currentNode = currentNode.getNext();
        }

        newValue.setNext(currentNode.getNext());
        currentNode.setNext(newValue);

        this.size++;
    }

    public T getByPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<T> currentNode = this.start;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    public int getPositionByValue(T value) {
        Node<T> currentNode = this.start;
        int position = 0;

        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return position;
            }
            currentNode = currentNode.getNext();
            position++;
        }

        return -1;
    }

    public void updateValue(T oldValue, T newValue) {
        Node<T> currentNode = this.start;

        while (currentNode != null) {
            if (currentNode.getValue().equals(oldValue)) {
                currentNode.setValue(newValue);
                return;
            }
            currentNode = currentNode.getNext();
        }

        System.out.println("Value not found in the list");
    }

    public void removeAtStart() {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }
        this.start = this.start.getNext();
        this.size--;
    }

    public void removeAtEnd() {
        if (this.start == null) {
            System.out.println("Empty list");
            return;
        }

        if (this.start.getNext() == null) {
            this.start = null;
        } else {
            Node<T> currentNode = this.start;
            Node<T> previousNode = null;

            while (currentNode.getNext() != null) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }

            previousNode.setNext(null);
        }
        this.size--;
    }

    public void removeByPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0) {
            removeAtStart();
            return;
        }

        Node<T> currentNode = this.start;
        Node<T> previousNode = null;

        for (int i = 0; i < position; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(currentNode.getNext());
        this.size--;
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

    public void clear() {
        this.start = null;
        this.size = 0;
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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
