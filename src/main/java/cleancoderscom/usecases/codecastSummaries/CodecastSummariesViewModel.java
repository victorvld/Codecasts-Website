package cleancoderscom.usecases.codecastSummaries;

import java.util.ArrayList;
import java.util.List;

public class CodecastSummariesViewModel {

    public ArrayList<ViewableCodecastSummary> viewableCodecastSummaries = new ArrayList<>();

    public void addModel(ViewableCodecastSummary viewableCodecastSummary) {
        viewableCodecastSummaries.add(viewableCodecastSummary);
    }

    public List<ViewableCodecastSummary> getViewableCodecasts() {
        return this.viewableCodecastSummaries;
    }

    public static class ViewableCodecastSummary {
        // The rule with object is to have all the fields private, but this is a data structure.
        // And in that case it doesn't matter to use public fields.
        // Datastructures and objects are different things. Episodes 5 & 11.
        public String title;
        public String permalink;
        public String publicationDate;
        public boolean isViewable;
        public boolean isDownloadable;
    }

}
