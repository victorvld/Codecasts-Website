package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.User;
import cleancoderscom.usecases.codecastSummaries.CodecastSummariesViewModel.ViewableCodecastSummary;

import java.time.format.DateTimeFormatter;

import static cleancoderscom.entities.License.LicenseType.DOWNLOADING;
import static cleancoderscom.entities.License.LicenseType.VIEWING;

public class CodecastSummariesPresenter implements CodecastSummariesOutputBoundary{

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private CodecastSummariesViewModel viewModel;

    @Override
    public CodecastSummariesViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public void present(CodecastSummariesResponseModel responseModel) {
        this.viewModel = new CodecastSummariesViewModel();
        for (CodecastSummary summary : responseModel.getCodecastSummaries()) {
            this.viewModel.addModel(makeViewable(summary));
        }
    }

    private ViewableCodecastSummary makeViewable(CodecastSummary codecastSummary ) {
        ViewableCodecastSummary viewSummary = new ViewableCodecastSummary();
        viewSummary.title = codecastSummary.title;
        viewSummary.publicationDate = codecastSummary.publicationDate.format(FORMATTER);
        viewSummary.permalink = codecastSummary.permalink;
        viewSummary.isViewable = codecastSummary.isViewable;;
        viewSummary.isDownloadable = codecastSummary.isDownloadable;;
        return viewSummary;
    }

}
