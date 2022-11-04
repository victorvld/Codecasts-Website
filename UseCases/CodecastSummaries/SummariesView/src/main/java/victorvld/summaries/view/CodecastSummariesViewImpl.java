package victorvld.summaries.view;

import victorvld.view.ViewTemplate;

import java.io.IOException;
import java.util.List;

public class CodecastSummariesViewImpl implements CodecastSummariesView {

    static String toHtml(List<CodecastSummariesViewModel.ViewableCodecastSummary> summaries) {
        try {
            ViewTemplate frontPageTemplate = ViewTemplate.create("cleancoderscom.summaries.view/html/frontpage.html");
            // We are going to collect all the code cast, we use a StringBuilder
            StringBuilder codecastsLines = new StringBuilder();
            for (CodecastSummariesViewModel.ViewableCodecastSummary summary : summaries) {
                ViewTemplate codecastTemplate = ViewTemplate.create("cleancoderscom.summaries.view/html/codecast.html");
                codecastTemplate.replace("title", summary.title);
                codecastTemplate.replace("publicationDate", summary.publicationDate);
                codecastTemplate.replace("permalink", summary.permalink);

                //staged
                codecastTemplate.replace("author", "Arranz");
                codecastTemplate.replace("duration", "50 min.");
                codecastTemplate.replace("contentActions", "Buying Options go here");

                codecastsLines.append(codecastTemplate.getContent());
            }
            frontPageTemplate.replace("codecasts", codecastsLines.toString());
            return makeResponse(frontPageTemplate.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Gunk";
    }

    private static String makeResponse(String content) {
        return "HTTP/1.1 200 OK\n" +
                "Content-Length: " + content.length() + "\n" +
                "\n" +
                content;
    }

    @Override
    public String generateView(CodecastSummariesViewModel view) {
        return toHtml(view.getViewableCodecasts());
    }
}
