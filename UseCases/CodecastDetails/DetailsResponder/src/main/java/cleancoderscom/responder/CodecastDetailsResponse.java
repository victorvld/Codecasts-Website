package cleancoderscom.responder;

import java.time.Duration;
import java.time.LocalDate;

public interface CodecastDetailsResponse {
    String getTitle();

    String getPermalink();

    String getAuthor();

    LocalDate getPublicationDate();

    Duration getDuration();
}
