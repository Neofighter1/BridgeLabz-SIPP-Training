package Collectors;

import java.util.*;
import java.util.stream.*;

class Book {
    String genre;
    int pages;
    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }
    String getGenre() { return genre; }
    int getPages() { return pages; }
}

public class BookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Fiction", 300),
            new Book("Fiction", 450),
            new Book("Science", 200),
            new Book("Science", 500)
        );

        Map<String, IntSummaryStatistics> stats = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summarizingInt(Book::getPages)
            ));

        System.out.println(stats);
    }
}