package victorvld.interactor;

import victorvld.entities.Codecast;
import victorvld.entities.User;
import victorvld.CodecastSummariesOutputBoundary;
import victorvld.context.Context;
import victorvld.entities.License;
import victorvld.requestor.request.Request;
import victorvld.requestor.usecase.UseCase;

import java.util.List;

public class CodecastSummariesUseCase implements UseCase {

    private final CodecastSummariesOutputBoundary presenter;

    public CodecastSummariesUseCase(CodecastSummariesOutputBoundary presenter) {
        this.presenter = presenter;
    }

    public static boolean isLicensedFor(License.LicenseType type, User user, Codecast codecast) {
        List<License> licenses = Context.licenseGateway.findLicensesForUserAndCodecast(user, codecast);
        for (License license : licenses) {
            if (license.getLicenseType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    private CodecastSummary summarizeCodecast(Codecast codecast, User user) {
        CodecastSummary summary = new CodecastSummary();
        summary.title = codecast.getTitle();
        summary.publicationDate = codecast.getPublicationDate();
        summary.permalink = codecast.getPermalink();
        summary.isViewable = isLicensedFor(License.LicenseType.VIEWING, user, codecast);
        summary.isDownloadable = isLicensedFor(License.LicenseType.DOWNLOADING, user, codecast);
        return summary;
    }

    @Override
    public String execute(Request request) {
        User loggedInUser = Context.userGateway.findUser(((SummariesRequest) request).userName);
        CodecastSummariesResponseModel responseModel = new CodecastSummariesResponseModel();
        List<Codecast> allCodecast = Context.codecastGateway.findAllCodecastSortedChronologically();
        for (Codecast codecast : allCodecast) {
            // We add an add function rather than exposing the list.
            responseModel.addCodecastSummary(summarizeCodecast(codecast, loggedInUser));
        }
        return presenter.present(responseModel);
    }
}
