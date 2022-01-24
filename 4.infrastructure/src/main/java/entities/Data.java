package entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table (name = "DATA")
public class Data {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "DATA_ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "FILE_PATH", nullable = false, length = 200)
    private String filePath;

}
