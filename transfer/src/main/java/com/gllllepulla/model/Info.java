package com.gllllepulla.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

public final class Info {
    private Info() {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Book(
            Integer id,
            String title,
            Integer yearPublication,
            String genreName,
            String publisherName,
            String authorName
    ) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Author(
            Integer id,
            String name,
            Instant born
    ) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Genre(
            Integer id,
            String genreName
    ) {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record BookishUser(
            Integer id,
            @NotBlank
            String name,
            @NotBlank
            String password,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled
    ) {
    }
}
