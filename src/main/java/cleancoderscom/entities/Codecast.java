package cleancoderscom.entities;

import java.time.Duration;
import java.time.LocalDate;

public class Codecast extends Entity {
    private String title;
    //This is a string for know. We w ill change it later as it can be a problem.
    private LocalDate publicationDate = LocalDate.now();
    private String permalink;

    private String author;
    private Duration duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPermalink() {
        return this.permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}

