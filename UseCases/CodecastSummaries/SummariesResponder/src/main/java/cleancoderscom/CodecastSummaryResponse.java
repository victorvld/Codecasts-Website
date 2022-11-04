package cleancoderscom;

import java.time.Duration;
import java.time.LocalDate;

public interface CodecastSummaryResponse {
    String getTitle();

    String getPermalink();

    LocalDate getPublicationDate();

    boolean isViewable();

    boolean isDownloadable();
}
