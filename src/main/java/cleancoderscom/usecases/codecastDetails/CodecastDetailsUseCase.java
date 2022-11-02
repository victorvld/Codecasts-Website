package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.Context;
import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.License;
import cleancoderscom.entities.User;
import cleancoderscom.usecases.Request;
import cleancoderscom.usecases.UseCase;

public class CodecastDetailsUseCase implements CodecastDetailsInputBoundary{
    @Override
    public void detailCodecasts(CodecastDetailsRequest request, CodecastDetailsOutputBoundary presenter) {
        User loggedInUser = Context.gateKeeper.getLoggedInUser();
        CodecastDetailsResponseModel responseModel = new CodecastDetailsResponseModel();
        Codecast codecast = Context.codecastGateway.findCodecastByPermalink(request.permalink);
        responseModel.permalink = codecast.getPermalink();
        responseModel.title = codecast.getTitle();
        responseModel.author = codecast.getAuthor();
        responseModel.publicationDate = codecast.getPublicationDate();
        responseModel.duration = codecast.getDuration();
        responseModel.licenseTypes = Context.licenseGateway.findLicensesForUserAndCodecast(loggedInUser, codecast)
                .stream().map(License::getLicenseType).toList();
        presenter.present(responseModel);
    }
}

