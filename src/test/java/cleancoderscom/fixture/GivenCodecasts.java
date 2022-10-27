package cleancoderscom.fixture;

import cleancoderscom.entities.Codecast;
import cleancoderscom.Context;

import java.time.LocalDate;

public class GivenCodecasts {

    private String title;
    private String publicationDate;
    private String permalink;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public void execute() {
        Codecast codecast = new Codecast();
        codecast.setTitle(title);
        codecast.setPermalink(permalink);
        codecast.setPublicationDate(LocalDate.parse(publicationDate));
        Context.codecastGateway.save(codecast);
    }
}
