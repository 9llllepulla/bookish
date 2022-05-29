package com.gllllepulla.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

/**
 * DTO record classes for entities transfer
 */
public final class Dto {

    private Dto() {
    }

    public record Author(
            long id,
            String name,
            Instant born
    ) {
    }

    public record Book(
            long id,
            String title,
            String authorName,
            int yearPublication,
            String genreName,
            String publisherName
    ) {
    }

    public record Genre(
            long id,
            String name
    ) {
    }

    public record Publisher(
            long id,
            String name
    ) {
    }

    public record BookishUser(
            Integer id,
            String name,
            String password,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled
    ) {
    }

}
