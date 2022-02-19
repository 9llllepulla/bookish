package com.gllllepulla.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table (name = "book")
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "book_id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "book_title", length = 200, nullable = false)
    private String title;

    @Basic
    @Column(name = "year_publication")
    private Integer yearPublication;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "data_id")
    private Data data;

    @Getter(AccessLevel.NONE)
    @Setter (AccessLevel.NONE)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookAuthor> bookAuthors = new HashSet<>();

    public void addAuthor(Author author) {
        BookAuthor bookAuthor = new BookAuthor(this, author);
        bookAuthors.add(bookAuthor);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        return title.equals(book.title);
    }

    @Override
    public int hashCode () {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }
}
