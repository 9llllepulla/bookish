package entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "author_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "author_name", length = 200)
    private String authorName;

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
