package com.gllllepulla.transfer;

import java.time.Instant;

/**
 * DTO record classes for entities transfer
 *
 */
public final class Dto {

    private Dto() {}

    public record Author(
            int id,
            String name,
            Instant born
    ) { }

    public record Book(
            int id,
            String title,
            String authorName,
            int yearPublication,
            String genreName,
            String publisherName
    ) { }

    public record Genre(
            int id,
            String name
    ) { }

    public record Publisher(
            int id,
            String name
    ) { }

}
