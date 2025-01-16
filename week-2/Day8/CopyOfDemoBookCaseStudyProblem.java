

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CopyOfDemoBookCaseStudyProblem {

    public static void main(String[] args) {

        List<Book> allBooks = loadAllBooks();

        // 1. Find books with more than 400 pages
        List<Book>booksMoreThen400Pages=allBooks.stream()
                .filter(b-> b.getPages()>400).toList();

        // 2. Find all books that are java books and more than 400 pages
        List<Book> javaBooksMoreThan400Pages = allBooks.stream()
                .filter(b -> b.getSubject().equals(Subject.JAVA) && b.getPages() > 400)
                .toList();
        javaBooksMoreThan400Pages.forEach(System.out::println);

        // 3. We need the top three longest books
//		List<Book> longestBook = allBooks.stream()
//				.sorted(Comparator.comparing(Book::getPages)).reversed().limit(3)
//				.collect(Collectors.toList());
//
//		// 4. We need from the fourth to the last longest books
//		List<Book> longestBookFromFourth= allBooks.stream()
//				.sorted(Comparator.comparable(Book::getPages)).reversed()
//				.skip(3).collect(Collectors.toList());
//
//		// 5. We need to get all the publishing years
//		List<Book> publishingYears = allBooks.stream()
//				.unique()
//		// 6. We need all the authors names who have written a book
//		List<Book> longestBook = allBooks.stream()
//		// We need all the origin countries of the authors
//		List<Book> longestBook = allBooks.stream()
//		// We want the most recent published book.
//		List<Book> longestBook = allBooks.stream()
//		// We want to know if all the books are written by more than one author
//		List<Book> longestBook = allBooks.stream()
//		// We want one of the books written by more than one author. (findAny)
//		List<Book> longestBook = allBooks.stream()
//		// We want the total number of pages published.
//		List<Book> longestBook = allBooks.stream()
//
//		// We want to know how many pages the longest book has.
//		List<Book> longestBook = allBooks.stream()
//
//		// We want the average number of pages of the books
//		List<Book> longestBook = allBooks.stream()
//		// We want all the titles of the books
//		List<Book> longestBook = allBooks.stream()
//
//		// We want the book with the higher number of authors?
//		List<Book> longestBook = allBooks.stream()
//
//		// We want a Map of book per year.
//		List<Book> longestBook = allBooks.stream()
//
//
//		// We want to count how many books are published per year.
//		List<Book> longestBook = allBooks.stream()
//

    }

    private static List<Book> loadAllBooks() {
        List<Book> books = new ArrayList<Book>();
        List<Author> authors1 = Arrays.asList(new Author("raj", "gupta", "in"),
                new Author("ekta", "gupta", "in"));

        List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

        List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
                new Author("keshav", "gupta", "us"));

        books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
        books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
        books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));

        return books;
    }

}
