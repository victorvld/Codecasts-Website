package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.Context;
import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.License;
import cleancoderscom.entities.User;

import java.util.List;

public class CodecastSummariesUseCase implements CodecastSummariesInputBoundary {

    public static boolean isLicensedFor(License.LicenseType type, User user, Codecast codecast) {
        List<License> licenses = Context.licenseGateway.findLicensesForUserAndCodecast(user, codecast);
        for (License license : licenses) {
            if (license.getLicenseType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void summarizeCodecasts(User loggedInUser, CodecastSummariesOutputBoundary presenter) {
        CodecastSummariesResponseModel responseModel = new CodecastSummariesResponseModel();
        List<Codecast> allCodecast = Context.codecastGateway.findAllCodecastSortedChronologically();
        for (Codecast codecast : allCodecast) {
            // We add an add function rather than exposing the list.
            responseModel.addCodecastSummary(summarizeCodecast(codecast, loggedInUser));
        }
        presenter.present(responseModel);
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
}
