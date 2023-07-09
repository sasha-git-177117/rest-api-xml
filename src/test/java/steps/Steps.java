package steps;

import com.google.common.collect.Comparators;
import models.Book;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Steps {

    public static List<String> getIdsBooks(List<Book> books) {
        List<String> idsBooks = new ArrayList<>();
        for (Book book : books) {
            idsBooks.add(book.getId());
        }
        return idsBooks;
    }

    public static boolean isAscendingOrder(List<Integer> elements) {
        return Comparators.isInOrder(elements, Comparator.naturalOrder());
    }

    public static Book getBookWithMinPrice(List<Book> books) {
        return books.stream()
                .min(Comparator.comparing(Book::getPrice))
                .get();
    }

    public static Book getBookWithMaxPrice(List<Book> books) {
        return books.stream()
                .max(Comparator.comparing(Book::getPrice))
                .get();
    }
}
