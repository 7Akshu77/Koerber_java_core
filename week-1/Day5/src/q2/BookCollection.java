package q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BookCollection implements Comparator<BookCollection> {
    private String authorName;
    private Book [] collection;

    public BookCollection(String authorName, Book[] books) {
        this.authorName = authorName;
        this.collection = books;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void hasBook(Book b){
        for(Book bk:collection){
            if(bk.equals(b)){
                System.out.println("Book found");
                return;
            }
        }
        System.out.println("Book not found");
    }
    public void sort() {
        Arrays.sort(collection);
    }

    // Method to sort books using a Comparator
    public void sort(SortBasedAuthor comparator) {
        Arrays.sort(collection, comparator);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book Collection of ").append(authorName).append(":\n");
        for (Book book : collection) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }


    @Override// book author
    public int compare(BookCollection o1, BookCollection o2) {
        return o1.getAuthorName().compareTo(o2.getAuthorName());
    }
}
