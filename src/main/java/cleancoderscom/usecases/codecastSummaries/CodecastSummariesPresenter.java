package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.usecases.codecastSummaries.CodecastSummariesViewModel.ViewableCodecastSummary;

import java.time.format.DateTimeFormatter;

public class CodecastSummariesPresenter implements CodecastSummariesOutputBoundary {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private CodecastSummariesViewModel viewModel;
    private CodecastSummariesView view;

    public CodecastSummariesPresenter(CodecastSummariesView view) {
        this.view = view;
    }

    @Override
    public CodecastSummariesViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public String present(CodecastSummariesResponseModel responseModel) {
        this.viewModel = new CodecastSummariesViewModel();
        for (CodecastSummary summary : responseModel.getCodecastSummaries()) {
            this.viewModel.addModel(makeViewable(summary));
        }
        return view.generateView(this.viewModel);
    }

    private ViewableCodecastSummary makeViewable(CodecastSummary codecastSummary) {
        ViewableCodecastSummary viewSummary = new ViewableCodecastSummary();
        viewSummary.title = codecastSummary.title;
        viewSummary.publicationDate = codecastSummary.publicationDate.format(FORMATTER);
        viewSummary.permalink = codecastSummary.permalink;
        viewSummary.isViewable = codecastSummary.isViewable;
        viewSummary.isDownloadable = codecastSummary.isDownloadable;
        return viewSummary;
    }

}
