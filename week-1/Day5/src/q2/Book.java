package q2;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String authorName;
    private String title;

    public Book(String authorName, String title) {
        this.authorName = authorName;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override// compares whether the book title and the author are the same
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Book bk = (Book) obj;
        return title.equalsIgnoreCase(bk.title) && authorName.equalsIgnoreCase(bk.authorName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), authorName.toLowerCase());
    }
    @Override// sorting based on title
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(authorName);
        return sb.toString();
    }
}
