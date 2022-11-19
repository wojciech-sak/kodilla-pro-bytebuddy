package com.kodilla.bytebuddy;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BuddyAppJavaAgent {
    public static void main(String[] args) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        List<Book> books = BooksGenerator.generate(100);
        BooksFilter booksFilter = new BooksFilter(books);
        List<Book> filteredBooks = booksFilter.onlyBooksOlderThan(20);
        System.out.println(filteredBooks.size());
    }
}
