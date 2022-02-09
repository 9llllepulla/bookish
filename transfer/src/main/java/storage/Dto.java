package storage;

/**
 * DTO record classes for entities transfer
 *
 */
public final class Dto {

    private Dto() {}

    public record Book(
            int id,
            String title,
            String author,
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
