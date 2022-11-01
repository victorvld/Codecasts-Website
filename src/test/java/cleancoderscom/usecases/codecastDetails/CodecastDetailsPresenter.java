package cleancoderscom.usecases.codecastDetails;

import java.time.format.DateTimeFormatter;

public class CodecastDetailsPresenter implements CodecastDetailsOutputBoundary {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private CodecastDetailsViewModel viewModel;

    @Override
    public CodecastDetailsViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public void present(CodecastDetailsResponseModel responseModel) {
        makeViewable(responseModel);
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
