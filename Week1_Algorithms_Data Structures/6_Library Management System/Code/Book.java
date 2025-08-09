public class Book {
    int bookId;
    String title;
    String author;
    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
    void display() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}
