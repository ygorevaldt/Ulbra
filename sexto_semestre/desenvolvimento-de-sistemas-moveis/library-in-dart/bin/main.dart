import '../lib/models/book.dart';
import '../lib/models/library.dart';

void main() {
  var myLibrary = Library();

  Book book1 = Book(
    title: 'Dom Casmurro',
    author: 'Machado de Assis',
    publicationYear: 1899,
    genre: 'Novel',
    id: '1',
  );
  Book book2 = Book(
    title: '1984',
    author: 'George Orwell',
    publicationYear: 1949,
    genre: 'Dystopia',
    id: '2',
  );
  Book book3 = Book(
    title: 'The Lord of the Rings',
    author: 'J.R.R. Tolkien',
    publicationYear: 1954,
    genre: 'Fantasy',
    id: '3',
  );

  myLibrary.registerBook(book1);
  myLibrary.registerBook(book2);
  myLibrary.registerBook(book3);

  myLibrary.listBooks();

  myLibrary.removeBookById('2');

  myLibrary.removeBookByTitle('Dom Casmurro');

  myLibrary.listBooks();
}
