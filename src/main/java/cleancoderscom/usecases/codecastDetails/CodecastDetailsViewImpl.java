package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.view.ViewTemplate;

import java.io.IOException;

public class CodecastDetailsViewImpl implements CodecastDetailsView {
    @Override
    public String generateView(CodecastDetailsViewModel viewModel) {
        return toHtml(viewModel);
    }

    private String toHtml(CodecastDetailsViewModel details) {
        try {
            ViewTemplate codecastTemplate = ViewTemplate.create("html/codecast.html");
            codecastTemplate.replace("title", details.title);
            codecastTemplate.replace("publicationDate", details.publicationDate);
            codecastTemplate.replace("permalink", details.permalink);

            //staged
            codecastTemplate.replace("thumbnail", "https://avatars.githubusercontent.com/u/12075?s=48&v=4");
            codecastTemplate.replace("author", details.author);
            codecastTemplate.replace("duration", details.duration);
            codecastTemplate.replace("contentActions", "Buying Options go here");

            return makeResponse(codecastTemplate.getContent());
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
}
