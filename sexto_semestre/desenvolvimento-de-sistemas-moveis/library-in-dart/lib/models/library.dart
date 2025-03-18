import 'book.dart';

class Library {
  List<Book> books = [];

  void registerBook(Book book) {
    books.add(book);
    print('Book "${book.title}" registered successfully!');
  }

  void removeBookById(String id) {
    books.removeWhere((book) => book.id == id);
    print('Book with ID "$id" removed successfully!');
  }

  void removeBookByTitle(String title) {
    books.removeWhere(
      (book) => book.title.toLowerCase() == title.toLowerCase(),
    );
    print('Book with title "$title" removed successfully!');
  }

  void listBooks() {
    if (books.isEmpty) {
      print('No books registered in the library.');
      return;
    }

    print('Books available in the library:');
    for (var book in books) {
      book.displayDetails();
    }
  }
}
