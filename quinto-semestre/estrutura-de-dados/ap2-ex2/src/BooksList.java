import java.util.UUID;

public class BooksList extends DoublyLinkedList<Book> {
	public void insertAtStart(Book book) {
		Node<Book> newNode = new Node<>(book);

		if (this.start == null) {
			this.start = newNode;
			this.end = newNode;
			return;
		}

		this.start.setPrevious(newNode);
		newNode.setNext(this.start);
		this.start = newNode;
	}

	public void insertAtEnd(Book book) {
		Node<Book> newNode = new Node<>(book);

		if (this.start == null) {
			this.start = newNode;
			this.end = newNode;
			return;
		}

		this.end.setNext(newNode);
		newNode.setPrevious(this.end);
		this.end = newNode;
	}

	public Book removeAtStart() {
		if (this.start == null) {
			System.out.println("Nenhum livro cadastrado");
			return null;
		}

		Book book = this.start.getValue();

		if (this.start == this.end) {
			this.start = null;
			this.end = null;
		} else {
			this.start = this.start.getNext();
			this.start.setPrevious(null);
		}

		return book;
	}

	public Book removeAtEnd() {
		if (this.start == null) {
			System.out.println("Nenhum livro cadastrado");
			return null;
		}

		Book book = this.end.getValue();

		if (this.start == this.end) {
			this.start = null;
			this.end = null;
		} else {
			this.end = this.end.getPrevious();
			this.end.setNext(null);
		}

		return book;
	}

	public Book findBookById(UUID id) {
		if (this.start == null) {
			System.out.println("Nenhum livro cadastrado");
			return null;
		}

		Node<Book> currentNode = this.start;
		while (currentNode != null) {
			Book book = currentNode.getValue();
			if (book.getId().equals(id)) {
				return book;
			}
			currentNode = currentNode.getNext();
		}

		System.out.println("Livro não encontrado");
		return null;
	}

	public void printBooks() {
		if (this.start == null) {
			System.out.println("Nenhum livro cadastrado");
			return;
		}

		Node<Book> currentNode = this.start;
		while (currentNode != null) {
			System.out.println(currentNode.getValue());
			currentNode = currentNode.getNext();
		}
	}

	public void printBooksReverse() {
		if (this.start == null) {
			System.out.println("Nenhum livro cadastrado");
			return;
		}

		Node<Book> currentNode = this.end;
		while (currentNode != null) {
			System.out.println(currentNode.getValue());
			currentNode = currentNode.getPrevious();
		}
	}
}
