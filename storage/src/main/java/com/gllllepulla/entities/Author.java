package com.gllllepulla.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Basic
    @Column (name = "author_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "author_name", length = 200)
    private String authorName;

    @Basic
    @Column(name = "author_born", length = 8)
    private Instant born;

    @Getter(AccessLevel.NONE)
    @Setter (AccessLevel.NONE)
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<BookAuthor> bookAuthors = new HashSet<>();

    public void addBook(Book book) {
        BookAuthor bookAuthor = new BookAuthor(book, this);
        bookAuthors.add(bookAuthor);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (!Objects.equals(id, author.id)) return false;
        return authorName.equals(author.authorName);
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + authorName.hashCode();
        return result;
    }
}
