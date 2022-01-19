package entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table (name = "PUBLISHER")
public class Publisher {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "publisherSeq")
    @Column (name = "PUBLISHER_ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "PUBLISHER_NAME", nullable = false, length = 200)
    private String publisherName;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (id != publisher.id) return false;
        return publisherName.equals(publisher.publisherName);
    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + publisherName.hashCode();
        return result;
    }
}
