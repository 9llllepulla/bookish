package com.gllllepulla.model;

import java.time.Instant;

/**
 * DTO record classes for entities transfer
 *
 */
public final class Dto {

    private Dto() {}

    public record Author(
            long id,
            String name,
            Instant born
    ) { }

    public record Book(
            long id,
            String title,
            String authorName,
            int yearPublication,
            String genreName,
            String publisherName
    ) { }

    public record Genre(
            long id,
            String name
    ) { }

    public record Publisher(
            long id,
            String name
    ) { }

}
