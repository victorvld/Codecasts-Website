package cleancoderscom.fixture;

import cleancoderscom.*;
import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.License;
import cleancoderscom.entities.User;
import cleancoderscom.TestSetup;
import cleancoderscom.usecases.codecastSummaries.*;


import java.util.ArrayList;
import java.util.List;

import static cleancoderscom.entities.License.LicenseType.DOWNLOADING;
import static cleancoderscom.entities.License.LicenseType.VIEWING;

public class CodeCastPresentation {

    //What is this? Look at the notes.
    public static GateKeeper gateKeeper = new GateKeeper();
    private CodecastSummariesOutputBoundarySpy presenter;

    public CodeCastPresentation() {
        TestSetup.setupContext();
    }

    public static List<CodecastSummariesViewModel.ViewableCodecastSummary> loadViewableCodecast() {
        User loggedInUser = gateKeeper.getLoggedInUser();
        CodecastSummariesOutputBoundary presenter = new CodecastSummariesPresenter();
        new CodecastSummariesUseCase().summarizeCodecasts(loggedInUser, presenter);
        List<CodecastSummariesViewModel.ViewableCodecastSummary> viewableCodecasts = presenter.getViewModel().getViewableCodecasts();
        return viewableCodecasts;
    }

    public boolean addUser(String userName) {
        Context.userGateway.save(new User(userName));
        return true;
    }

    public boolean loginUser(String userName) {
        User user = Context.userGateway.findUser(userName);
        if (user != null) {
            gateKeeper.setLoggedInUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean createLicenseForViewing(String username, String codecastTitle) {
        return createLicenseForType(VIEWING, username, codecastTitle);
    }

    public boolean createLicensesForDownloading(String username, String codecastTitle) {
        return createLicenseForType(DOWNLOADING, username, codecastTitle);
    }

    private boolean createLicenseForType(License.LicenseType type, String username, String codecastTitle) {
        User user = Context.userGateway.findUser(username);
        Codecast codecast = Context.codecastGateway.findCodecastByTitle(codecastTitle);
        License license = new License(type, user, codecast);
        Context.licenseGateway.save(license);
        return CodecastSummariesUseCase.isLicensedFor(type, user, codecast);
    }

    public String presentationUser() {
        return gateKeeper.getLoggedInUser().getUserName();
    }

    public boolean clearCodecast() {
        // We need some application context to pick the database.
        // We one a single one placed where we do all the dependency injection.
        List<Codecast> codecasts = Context.codecastGateway.findAllCodecastSortedChronologically();
        for (Codecast codecast : new ArrayList<>(codecasts)) {
            Context.codecastGateway.delete(codecast);
        }
        return codecasts.size() == 0;
    }

    public int countOfCodecastPresented() {
        return loadViewableCodecast().size();
    }
}
