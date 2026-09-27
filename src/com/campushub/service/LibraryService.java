package com.campushub.service;

import com.campushub.model.Book;
import com.campushub.model.LibraryRecord;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Book> books = new ArrayList<>();
    private final List<LibraryRecord> records = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public List<Book> getAllBooks() { return books; }

    public boolean issueBook(int bookId, String usn) {
        Book book = findBook(bookId);
        if (book == null || !book.isAvailable()) return false;
        book.setAvailable(false);
        records.add(new LibraryRecord(usn, bookId));
        return true;
    }

    public boolean returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null || book.isAvailable()) return false;

        for (LibraryRecord record : records) {
            if (record.getBookId() == bookId && !record.isReturned()) {
                record.markReturned();
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    private Book findBook(int id) {
        for (Book book : books) if (book.getId() == id) return book;
        return null;
    }
}
