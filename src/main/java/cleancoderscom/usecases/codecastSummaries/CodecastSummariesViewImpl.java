package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.usecases.codecastSummaries.CodecastSummariesViewModel.ViewableCodecastSummary;
import cleancoderscom.view.ViewTemplate;

import java.io.IOException;
import java.util.List;

public class CodecastSummariesViewImpl implements CodecastSummariesView {

    static String toHtml(List<ViewableCodecastSummary> summaries) {
        try {
            ViewTemplate frontPageTemplate = ViewTemplate.create("html/frontpage.html");
            // We are going to collect all the code cast, we use a StringBuilder
            StringBuilder codecastsLines = new StringBuilder();
            for (ViewableCodecastSummary summary : summaries) {
                ViewTemplate codecastTemplate = ViewTemplate.create("html/codecast.html");
                codecastTemplate.replace("title", summary.title);
                codecastTemplate.replace("publicationDate", summary.publicationDate);
                codecastTemplate.replace("permalink", summary.permalink);

                //staged
                codecastTemplate.replace("thumbnail", "https://avatars.githubusercontent.com/u/12075?s=48&v=4");
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
    public String generateView(CodecastSummariesViewModel viewModel) {
        return toHtml(viewModel.getViewableCodecasts());
    }
}
