package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.TestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static cleancoderscom.entities.License.LicenseType.VIEWING;

class CodecastDetailsUseCaseTest {
    private CodecastDetailsUseCase useCase;
    private CodecastDetailsOutputBoundarySpy presenter;

    @BeforeEach
    public void setUp() {
        TestSetup.setupSampleData();
        this.presenter = new CodecastDetailsOutputBoundarySpy();
        this.useCase = new CodecastDetailsUseCase(this.presenter);
    }

    @Test
    void when_detailCodecastIsCalled_then_ResponseModelIsGeneratedProperly_and_forwarded_to_PresentMethod() {
        DetailsRequest request = new DetailsRequest();
        request.permalink = "e1";

        this.useCase.execute(request);

        CodecastDetailsResponseModel responseModel = presenter.responseModel;
        Assertions.assertNotNull(responseModel);
        Assertions.assertEquals("e1", responseModel.permalink);
        Assertions.assertEquals("Episode 1 - The Beginning", responseModel.title);
        Assertions.assertEquals("Bob", responseModel.author);
        Assertions.assertEquals(LocalDate.of(2022,11,19), responseModel.publicationDate);
        Assertions.assertEquals(Duration.of(100, ChronoUnit.MINUTES), responseModel.duration);
        Assertions.assertArrayEquals(List.of(VIEWING).toArray(), responseModel.licenseTypes.toArray());
    }

    // TODO : Add more tests and continue testing the codecast details workflow, i.e., presenter and view.
    // 1) Create CodecastDetailsPresenterTest
}