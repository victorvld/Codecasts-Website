package cleancoderscom.summaries.interactor;

import cleancoderscom.CodecastSummaryResponse;
import cleancoderscom.context.Context;
import cleancoderscom.context.setup.TestSetup;
import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.License;
import cleancoderscom.entities.User;
import cleancoderscom.summaries.interactor.doubles.CodecastSummariesOutputBoundarySpy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cleancoderscom.entities.License.LicenseType.DOWNLOADING;
import static cleancoderscom.entities.License.LicenseType.VIEWING;

class CodecastSummariesUseCaseTest {

    private User user;
    private Codecast codecast;
    private CodecastSummariesUseCase useCase;
    private CodecastSummariesOutputBoundarySpy presenterSpy;

    @BeforeEach
    public void setup() {
        TestSetup.setupContext();
        user = Context.userGateway.save(new User("User"));
        Context.gateKeeper.setLoggedInUser(user);
        codecast = Context.codecastGateway.save(new Codecast());
        presenterSpy = new CodecastSummariesOutputBoundarySpy();
        useCase = new CodecastSummariesUseCase(presenterSpy);

    }

    @Test
    void useCaseWiring() {
        // useCase make the response model.
        // send response model to presenter.
        // assert sth about response model in the presenter.
        useCase.execute(null);
        Assertions.assertNotNull(presenterSpy.response);


    }

    @Test
    void userWithoutViewLicense_cannotViewCodecast() {
        Assertions.assertFalse(useCase.isLicensedFor(VIEWING, user, codecast));
    }

    @Test
    void userWithViewLicense_canViewCodecast() {
        Context.licenseGateway.save(new License(VIEWING, user, codecast));

        Assertions.assertTrue(useCase.isLicensedFor(VIEWING, user, codecast));
    }

    @Test
    void userWithoutViewLicense_cannotViewOtherUsersCodecast() {
        User otherUser = Context.userGateway.save(new User("OtherUser"));
        Context.licenseGateway.save(new License(VIEWING, user, codecast));

        Assertions.assertFalse(useCase.isLicensedFor(VIEWING, otherUser, codecast));
    }

    @Test
    public void presentingNoCodecasts() {
        // This is awful we will fix that by using a hierarchical context
        Context.codecastGateway.delete(codecast);
        useCase.execute(null);

        Assertions.assertEquals(0, presenterSpy.response.getCodecastSummaries().size());
    }

    @Test
    public void presentOneCodecast() {
        codecast.setTitle("Some Title");
        codecast.setPublicationDate(LocalDate.of(2022, 10, 17));
        codecast.setPermalink("permalink");
        Context.codecastGateway.save(codecast);
        useCase.execute(null);

        Assertions.assertEquals(1, presenterSpy.response.getCodecastSummaries().size());
        CodecastSummaryResponse codecastSummary = presenterSpy.response.getCodecastSummaries().get(0);
        Assertions.assertEquals("Some Title", codecastSummary.getTitle());
        // This was wrong, it should be a LocalTime not a String.
        // Assertions.assertEquals("17.10.2022", codecastSummary.publicationDate);
        Assertions.assertEquals(LocalDate.of(2022, 10, 17), codecastSummary.getPublicationDate());

        Assertions.assertEquals("permalink", codecastSummary.getPermalink());
    }

    @Test
    public void presentedCodecastIsNotViewableIfNotLicense() {
        useCase.execute(null);

        CodecastSummaryResponse codecastSummaries = presenterSpy.response.getCodecastSummaries().get(0);
        Assertions.assertFalse(codecastSummaries.isViewable());
    }

    @Test
    public void presentedCodecastIsViewableIfNotLicenseExists() {
        Context.licenseGateway.save(new License(VIEWING, user, codecast));

        useCase.execute(null);

        CodecastSummaryResponse codecastSummaries = presenterSpy.response.getCodecastSummaries().get(0);
        Assertions.assertTrue(codecastSummaries.isViewable());
    }

    @Test
    public void presentedCodecastIsDownloadableIfDownloadLicenseExists() {
        License downloadLicense = new License(DOWNLOADING, user, codecast);
        Context.licenseGateway.save(downloadLicense);

        useCase.execute(null);

        CodecastSummaryResponse summary = presenterSpy.response.getCodecastSummaries().get(0);
        Assertions.assertTrue(summary.isDownloadable());
        Assertions.assertFalse(summary.isViewable());

    }

}