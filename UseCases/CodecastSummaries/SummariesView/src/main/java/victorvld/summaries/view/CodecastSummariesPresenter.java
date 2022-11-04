package victorvld.summaries.view;

import victorvld.CodecastSummariesOutputBoundary;
import victorvld.CodecastSummariesResponse;
import victorvld.CodecastSummaryResponse;

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

    private CodecastSummariesViewModel.ViewableCodecastSummary makeViewable(CodecastSummaryResponse summaryResponse) {
        CodecastSummariesViewModel.ViewableCodecastSummary viewSummary = new CodecastSummariesViewModel.ViewableCodecastSummary();
        viewSummary.title = summaryResponse.getTitle();
        viewSummary.publicationDate = summaryResponse.getPublicationDate().format(FORMATTER);
        viewSummary.permalink = summaryResponse.getPermalink();
        viewSummary.isViewable = summaryResponse.isViewable();
        viewSummary.isDownloadable = summaryResponse.isDownloadable();
        return viewSummary;
    }

}
