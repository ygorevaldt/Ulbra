class Book {
  String title;
  String author;
  int publicationYear;
  String genre;
  String id;

  Book({
    required this.title,
    required this.author,
    required this.publicationYear,
    required this.genre,
    required this.id,
  });

  void displayDetails() {
    print('---');
    print('ID: $id');
    print('Title: $title');
    print('Author: $author');
    print('Publication Year: $publicationYear');
    print('Genre: $genre');
    print('---');
  }
}
