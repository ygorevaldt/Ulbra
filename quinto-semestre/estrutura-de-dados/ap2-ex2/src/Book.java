import java.util.UUID;

public class Book {
	private UUID id;
	private String title;
	private String author;

	public Book(String title, String author) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.author = author;
	}

	public UUID getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return String.format("{ id: %s, titulo: %s, autor: %s }", this.id, this.title, this.author);
	}
}
