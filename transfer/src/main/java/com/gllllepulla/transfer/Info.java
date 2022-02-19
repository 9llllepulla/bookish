package com.gllllepulla.transfer;

import java.time.Instant;

public final class Info {
    private Info (){}

    public record Book(
            int id,
            String title,
            int yearPublication,
            String genreName,
            String publisherName,
            String authorName
    ) { }

    public record Author(
            int id,
            String name,
            Instant born
    ) { }

    public record Genre(
            int id,
            String genreName
    ) { }

}