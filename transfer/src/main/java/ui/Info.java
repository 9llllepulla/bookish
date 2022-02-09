package ui;

public final class Info {
    private Info (){}

    public record Book(
            int id,
            String title,
            int yearPublication,
            String genreName,
            String publisherName) { }

    public record Author(
            int id,
            String name) { }

}
