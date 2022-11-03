package cleancoderscom.view;

import cleancoderscom.responder.CodecastDetailsOutputBoundary;
import cleancoderscom.responder.CodecastDetailsResponse;

import java.time.format.DateTimeFormatter;

public class CodecastDetailsPresenter implements CodecastDetailsOutputBoundary {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final CodecastDetailsView view;
    private CodecastDetailsViewModel viewModel;

    public CodecastDetailsPresenter(CodecastDetailsView view) {
        this.view = view;
    }

    @Override
    public String present(CodecastDetailsResponse detailsResponse) {
        makeViewable(detailsResponse);
        return view.generateView(this.viewModel);
    }

    private void makeViewable(CodecastDetailsResponse detailsResponse) {
        this.viewModel = new CodecastDetailsViewModel();
        this.viewModel.title = detailsResponse.getTitle();
        this.viewModel.permalink = detailsResponse.getPermalink();
        this.viewModel.author = detailsResponse.getAuthor();
        this.viewModel.publicationDate = detailsResponse.getPublicationDate().format(FORMATTER);
        this.viewModel.duration = String.format("%s minutes.", detailsResponse.getDuration().toMinutes());
    }
}
