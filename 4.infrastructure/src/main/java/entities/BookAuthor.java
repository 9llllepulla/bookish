package entities;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@ToString(onlyExplicitlyIncluded = true)
@Table (name = "book_author")
public class BookAuthor {

    @ToString.Include
    @EmbeddedId
    private BookAuthorPK primaryKey;

    @MapsId ("bookId")
    @ManyToOne (optional = false, fetch = FetchType.LAZY)
    @JoinColumn (name = "book_id", nullable = false)
    private Book book;

    @MapsId("authorId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public BookAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
        this.primaryKey = new BookAuthorPK(book.getId(), author.getId());
    }

    protected BookAuthor() {}

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookAuthor that = (BookAuthor) o;
        return primaryKey != null && Objects.equals(primaryKey, that.primaryKey);
    }

    @Override
    public int hashCode () {
        return Objects.hash(primaryKey);
    }
}
