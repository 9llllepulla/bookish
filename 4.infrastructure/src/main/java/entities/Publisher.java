package entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table (name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "publisher_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "publisher_name", length = 200)
    private String publisherName;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (!Objects.equals(id, publisher.id)) return false;
        return publisherName.equals(publisher.publisherName);
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + publisherName.hashCode();
        return result;
    }
}
