package victorvld.interactor;

import victorvld.CodecastSummaryResponse;

import java.time.LocalDate;

public class CodecastSummary implements CodecastSummaryResponse {
    public String title;
    public String permalink;
    public LocalDate publicationDate;
    public boolean isViewable;
    public boolean isDownloadable;

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getPermalink() {
        return this.permalink;
    }

    @Override
    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    @Override
    public boolean isViewable() {
        return this.isViewable;
    }

    @Override
    public boolean isDownloadable() {
        return this.isDownloadable;
    }
}
