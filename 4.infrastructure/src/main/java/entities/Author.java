package entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "authorSeq")
    @Column (name = "AUTHOR_ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "AUTHOR_NAME", nullable = false, length = 200)
    private String authorName;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        return authorName.equals(author.authorName);
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + authorName.hashCode();
        return result;
    }
}
