package cleancoderscom.usecases.codecastDetails;

import java.time.format.DateTimeFormatter;

public class CodecastDetailsPresenter implements CodecastDetailsOutputBoundary {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final CodecastDetailsView view;
    private CodecastDetailsViewModel viewModel;

    public CodecastDetailsPresenter(CodecastDetailsView view) {
        this.view = view;
    }

    @Override
    public CodecastDetailsViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public String present(CodecastDetailsResponseModel responseModel) {
        makeViewable(responseModel);
        return view.generateView(viewModel);
    }

    private void makeViewable(CodecastDetailsResponseModel responseModel) {
        this.viewModel = new CodecastDetailsViewModel();
        this.viewModel.title = responseModel.title;
        this.viewModel.permalink = responseModel.permalink;
        this.viewModel.author = responseModel.author;
        this.viewModel.publicationDate = responseModel.publicationDate.format(FORMATTER);
        this.viewModel.duration = String.format("%s minutes.", responseModel.duration.toMinutes());
    }
}
