package com.gllllepulla.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic
    @Column (name = "role_id", nullable = false)
    private Integer roleId;

    @Basic
    @Column(name = "role_name", length = 20, nullable = false)
    private String roleName;

    @Basic
    @Column(name = "role_description", length = 100)
    private String roleDescription;

    @JoinColumn(name = "create_by")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User createBy;

    @Basic
    @Column(name = "created_date", nullable = false)
    private Instant createDate;

    @JoinColumn(name = "last_modified_by")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User lastModifiedBy;

    @Basic
    @Column(name = "last_modified_date", nullable = false)
    private Instant lastModifiedDate;

    @Basic
    @Column(name = "read_only", nullable = false)
    private boolean readOnly;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (!roleId.equals(userRole.roleId)) return false;
        return createDate.equals(userRole.createDate);
    }

    @Override
    public int hashCode() {
        int result = roleId.hashCode();
        result = 31 * result + createDate.hashCode();
        return result;
    }
}
