package com.campushub.model;

import java.time.LocalDate;

public class LibraryRecord {
    private final String usn;
    private final int bookId;
    private final LocalDate issueDate;
    private LocalDate returnDate;

    public LibraryRecord(String usn, int bookId) {
        this.usn = usn;
        this.bookId = bookId;
        this.issueDate = LocalDate.now();
    }

    public int getBookId() { return bookId; }
    public boolean isReturned() { return returnDate != null; }

    public void markReturned() {
        returnDate = LocalDate.now();
    }
}
