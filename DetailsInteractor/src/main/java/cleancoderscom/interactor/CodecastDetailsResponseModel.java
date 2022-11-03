package cleancoderscom.interactor;


import cleancoderscom.responder.CodecastDetailsResponse;
import cleancoderscom.entities.License;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class CodecastDetailsResponseModel implements CodecastDetailsResponse {
    public String permalink;
    public String title;
    public String author;
    public LocalDate publicationDate;
    public Duration duration;
    public List<License.LicenseType> licenseTypes;

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getPermalink() {
        return this.permalink;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    @Override
    public Duration getDuration() {
        return this.duration;
    }
}
