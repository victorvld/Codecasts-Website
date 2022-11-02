package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.Context;
import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.License;
import cleancoderscom.entities.User;
import cleancoderscom.usecases.Request;
import cleancoderscom.usecases.UseCase;

public class CodecastDetailsUseCase implements UseCase {

    private CodecastDetailsOutputBoundary presenter;

    public CodecastDetailsUseCase(CodecastDetailsOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public String execute(Request request) {
        DetailsRequest detailsRequest = (DetailsRequest) request;
        User loggedInUser = Context.gateKeeper.getLoggedInUser();
        CodecastDetailsResponseModel responseModel = new CodecastDetailsResponseModel();
        Codecast codecast = Context.codecastGateway.findCodecastByPermalink(detailsRequest.permalink);
        responseModel.permalink = codecast.getPermalink();
        responseModel.title = codecast.getTitle();
        responseModel.author = codecast.getAuthor();
        responseModel.publicationDate = codecast.getPublicationDate();
        responseModel.duration = codecast.getDuration();
        responseModel.licenseTypes = Context.licenseGateway.findLicensesForUserAndCodecast(loggedInUser, codecast)
                .stream().map(License::getLicenseType).toList();
        return presenter.present(responseModel);
    }
}

