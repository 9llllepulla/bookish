package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Getter
@Embeddable
public class BookAuthorPK implements Serializable {

    @JoinColumn (name = "book_id", nullable = false)
    private int bookId;
    @JoinColumn(name = "author_id", nullable = false)
    private int authorId;

    protected BookAuthorPK(int bookId, int authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    protected BookAuthorPK() {}

}
