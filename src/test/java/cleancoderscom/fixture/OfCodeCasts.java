package cleancoderscom.fixture;

import cleancoderscom.usecases.codecastSummaries.CodecastSummariesViewModel.ViewableCodecastSummary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfCodeCasts {

    public List<Object> list(Object... objects) {
        return Arrays.asList(objects);
    }

    public List<Object> query() {
        List<ViewableCodecastSummary> viewableCodecasts = CodeCastPresentation.loadViewableCodecast();
        List<Object> queryResponse = new ArrayList<>();
        for (ViewableCodecastSummary summary : viewableCodecasts) {
            queryResponse.add(makeRow(summary));
        }
        return queryResponse;
    }

    private List<Object> makeRow(ViewableCodecastSummary summary) {
        return list(
                list("title", summary.title),
                list("publication date", summary.publicationDate),
                list("picture", summary.title),
                list("description", summary.title),
                list("viewable", summary.isViewable ? "+" : "-"),
                list("downloadable", summary.isDownloadable ? "+" : "-"));
    }

}
