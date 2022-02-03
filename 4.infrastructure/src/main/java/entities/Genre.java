package entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table (name = "genre")
public class Genre {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "genre_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "genre_name", length = 200)
    private String genreName;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (!Objects.equals(id, genre.id)) return false;
        return genreName.equals(genre.genreName);
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + genreName.hashCode();
        return result;
    }
}
