package com.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table (name = "data")
public class Data {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "data_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "file_path", length = 200)
    private String filePath;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (!id.equals(data.id)) return false;
        return filePath.equals(data.filePath);
    }

    @Override
    public int hashCode () {
        int result = id.hashCode();
        result = 31 * result + filePath.hashCode();
        return result;
    }
}
