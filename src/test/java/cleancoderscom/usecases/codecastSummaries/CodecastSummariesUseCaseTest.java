package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.Context;
import cleancoderscom.TestSetup;
import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.License;
import cleancoderscom.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cleancoderscom.entities.License.LicenseType.DOWNLOADING;
import static cleancoderscom.entities.License.LicenseType.VIEWING;

class CodecastSummariesUseCaseTest {

    private User user;
    private Codecast codecast;
    private CodecastSummaryUseCase useCase;
    private CodecastSummariesOutputBoundarySpy presenterSpy;

    @BeforeEach
    public void setup() {
        TestSetup.setupContext();
        user = Context.userGateway.save(new User("User"));
        codecast = Context.codecastGateway.save(new Codecast());
        useCase = new CodecastSummaryUseCase();
        presenterSpy = new CodecastSummariesOutputBoundarySpy();
    }

    @Test
    void useCaseWiring() {

        CodecastSummariesOutputBoundarySpy presenterSpy = new CodecastSummariesOutputBoundarySpy();
        useCase.summarizeCodecasts(user, presenterSpy);
        Assertions.assertNotNull(presenterSpy.responseModel);
        // useCase make the response model.
        // send reponse model to presenter.
        // assert sth about response model in the presenter.

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
        useCase.summarizeCodecasts(user, presenterSpy);

        Assertions.assertEquals(0, presenterSpy.responseModel.getCodecastSummaries().size());
    }

    @Test
    public void presentOneCodecast() {
        codecast.setTitle("Some Title");
        codecast.setPublicationDate(LocalDate.of(2022, 10,17));
        codecast.setPermalink("permalink");
        Context.codecastGateway.save(codecast);

        useCase.summarizeCodecasts(user, presenterSpy);

        Assertions.assertEquals(1, presenterSpy.responseModel.getCodecastSummaries().size());
        CodecastSummary codecastSummary  = presenterSpy.responseModel.getCodecastSummaries().get(0);
        Assertions.assertEquals("Some Title", codecastSummary.title);
        // This was wrong, it should be a LocalTime not a String.
        // Assertions.assertEquals("17.10.2022", codecastSummary.publicationDate);
        Assertions.assertEquals(LocalDate.of(2022, 10,17), codecastSummary.publicationDate);

        Assertions.assertEquals("permalink", codecastSummary.permalink);
    }

    @Test
    public void presentedCodecastIsNotViewableIfNotLicense() {
        useCase.summarizeCodecasts(user, presenterSpy);
        CodecastSummary codecastSummaries = presenterSpy.responseModel.getCodecastSummaries().get(0);
        Assertions.assertFalse(codecastSummaries.isViewable);
    }

    @Test
    public void presentedCodecastIsViewableIfNotLicenseExists() {
        Context.licenseGateway.save(new License(VIEWING, user, codecast));
        useCase.summarizeCodecasts(user, presenterSpy);
        CodecastSummary codecastSummaries = presenterSpy.responseModel.getCodecastSummaries().get(0);
        Assertions.assertTrue(codecastSummaries.isViewable);
    }

    @Test
    public void presentedCodecastIsDownloadableIfDownloadLicenseExists() {
        License downloadLicense = new License(DOWNLOADING, user, codecast);
        Context.licenseGateway.save(downloadLicense);
        useCase.summarizeCodecasts(user, presenterSpy);
        CodecastSummary summary = presenterSpy.responseModel.getCodecastSummaries().get(0);
        Assertions.assertTrue(summary.isDownloadable);
        Assertions.assertFalse(summary.isViewable);

    }

}