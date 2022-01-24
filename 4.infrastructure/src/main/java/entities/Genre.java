package entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table (name = "GENRE")
public class Genre {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "GENRE_ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "GENRE_NAME", nullable = false, length = 200)
    private String genreName;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        return genreName.equals(genre.genreName);
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + genreName.hashCode();
        return result;
    }
}
