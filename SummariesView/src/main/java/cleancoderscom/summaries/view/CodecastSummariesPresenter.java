package cleancoderscom.summaries.view;

import cleancoderscom.CodecastSummariesOutputBoundary;
import cleancoderscom.CodecastSummariesResponse;
import cleancoderscom.CodecastSummaryResponse;
import cleancoderscom.summaries.view.CodecastSummariesViewModel.ViewableCodecastSummary;

import java.time.format.DateTimeFormatter;

public class CodecastSummariesPresenter implements CodecastSummariesOutputBoundary {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private CodecastSummariesViewModel viewModel;
    private CodecastSummariesView view;

    public CodecastSummariesPresenter(CodecastSummariesView view) {
        this.view = view;
    }

    @Override
    public String present(CodecastSummariesResponse SummariesResponse) {
        this.viewModel = new CodecastSummariesViewModel();
        for (CodecastSummaryResponse summary : SummariesResponse.getCodecastSummaries()) {
            this.viewModel.addModel(makeViewable(summary));
        }
        return view.generateView(this.viewModel);
    }

    private ViewableCodecastSummary makeViewable(CodecastSummaryResponse summaryResponse) {
        ViewableCodecastSummary viewSummary = new ViewableCodecastSummary();
        viewSummary.title = summaryResponse.getTitle();
        viewSummary.publicationDate = summaryResponse.getPublicationDate().format(FORMATTER);
        viewSummary.permalink = summaryResponse.getPermalink();
        viewSummary.isViewable = summaryResponse.isViewable();
        viewSummary.isDownloadable = summaryResponse.isDownloadable();
        return viewSummary;
    }

}
