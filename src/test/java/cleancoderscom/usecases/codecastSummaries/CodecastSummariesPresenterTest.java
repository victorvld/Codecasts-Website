package cleancoderscom.usecases.codecastSummaries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CodecastSummariesPresenterTest {

    @Test
    void validateViewModel() {
        CodecastSummariesResponseModel rm = new CodecastSummariesResponseModel();
        CodecastSummary summary = new CodecastSummary();
        summary.title = "codecast";
        summary.permalink = "permalink";
        summary.publicationDate = LocalDate.of(2022, 10, 17);
        summary.isDownloadable = true;
        summary.isViewable = true;

        rm.addCodecastSummary(summary);
        CodecastSummariesPresenter presenter = new CodecastSummariesPresenter();

        presenter.present(rm);
        CodecastSummariesViewModel viewModel = presenter.getViewModel();

        CodecastSummariesViewModel.ViewableCodecastSummary viewableCodecastSummary = viewModel.viewableCodecastSummaries.get(0);
        Assertions.assertEquals(summary.title, viewableCodecastSummary.title);
    }

}