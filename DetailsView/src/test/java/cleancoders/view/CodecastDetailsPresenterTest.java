package cleancoders.view;

import cleancoders.view.doubles.CodecastDetailsViewSpy;
import cleancoderscom.entities.License;
import cleancoderscom.responder.CodecastDetailsResponse;
import cleancoderscom.view.CodecastDetailsPresenter;
import cleancoderscom.view.CodecastDetailsViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


class CodecastDetailsPresenterTest {

//    @Test
//    void present() {
//        CodecastDetailsResponse rm = new CodecastDetailsResponse();
//        rm.title = "codecast";
//        rm.permalink = "permalink";
//        rm.publicationDate = LocalDate.of(2022, 10, 17);
//        rm.author = "Benito";
//        rm.licenseTypes = List.of(License.LicenseType.VIEWING);
//        rm.duration = Duration.of(100, ChronoUnit.MINUTES);
//        CodecastDetailsViewSpy view = new CodecastDetailsViewSpy();
//        CodecastDetailsPresenter presenter = new CodecastDetailsPresenter(view);
//
//        presenter.present(rm);
//
//        CodecastDetailsViewModel viewModel = presenter.getViewModel();
//        Assertions.assertEquals(rm.title, viewModel.title);
//        Assertions.assertEquals(rm.permalink, viewModel.permalink);
//        Assertions.assertEquals("17.10.2022", viewModel.publicationDate);
//        Assertions.assertEquals(rm.author, viewModel.author);
//        Assertions.assertEquals("100 minutes.", viewModel.duration);
//    }

}