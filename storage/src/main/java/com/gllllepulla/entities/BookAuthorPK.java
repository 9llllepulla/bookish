package com.gllllepulla.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Getter
@Embeddable
@Table(name = "book_author")
public class BookAuthorPK implements Serializable {

    @JoinColumn (name = "book_id", nullable = false)
    private Long bookId;
    @JoinColumn(name = "author_id", nullable = false)
    private Long authorId;

    protected BookAuthorPK(long bookId, long authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    protected BookAuthorPK() {}

}
