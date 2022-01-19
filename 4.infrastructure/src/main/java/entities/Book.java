package entities;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Table (name = "BOOK")
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "bookSeq")
    @Column (name = "BOOK_ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "BOOK_TITLE", nullable = false, length = 200)
    private String title;

    @Basic
    @Column(name = "YEAR_PUBLICATION")
    private Timestamp yearPublication;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", nullable = false, updatable = false)
    private Genre genre;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", nullable = false, updatable = false)
    private Publisher publisher;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (!title.equals(book.title)) return false;
        return Objects.equals(yearPublication, book.yearPublication);
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + title.hashCode();
        return result;
    }
}
