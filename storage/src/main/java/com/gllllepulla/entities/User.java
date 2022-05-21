package com.gllllepulla.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column (name = "user_id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "user_login", length = 100, nullable = false)
    private String login;

    @Basic
    @Column(name = "user_password", length = 1000, nullable = false)
    private String password;

    @Basic
    @Column(name = "first_name", length = 100)
    private String userFirstName;

    @Basic
    @Column(name = "last_name", length = 100)
    private String userLastName;

    @Basic
    @Column(name = "email", length = 200, nullable = false)
    private String userEmail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
