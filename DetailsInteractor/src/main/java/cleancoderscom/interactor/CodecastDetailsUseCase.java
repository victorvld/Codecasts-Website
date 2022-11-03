package cleancoderscom.interactor;

import cleancoderscom.entities.Codecast;
import cleancoderscom.responder.CodecastDetailsOutputBoundary;
import cleancoderscom.context.Context;
import cleancoderscom.entities.License;
import cleancoderscom.entities.User;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.requestor.usecase.UseCase;

public class CodecastDetailsUseCase implements UseCase {

    private final CodecastDetailsOutputBoundary presenter;

    public CodecastDetailsUseCase(CodecastDetailsOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public String execute(Request request) {
        User user = Context.gateKeeper.getLoggedInUser();
        Codecast codecast = Context.codecastGateway.findCodecastByPermalink(((DetailsRequest) request).permalink);
        return presenter.present(this.generateResponseModel(user, codecast));
    }

    private CodecastDetailsResponseModel generateResponseModel(User loggedInUser, Codecast codecast) {
        CodecastDetailsResponseModel responseModel = new CodecastDetailsResponseModel();
        responseModel.permalink = codecast.getPermalink();
        responseModel.title = codecast.getTitle();
        responseModel.author = codecast.getAuthor();
        responseModel.publicationDate = codecast.getPublicationDate();
        responseModel.duration = codecast.getDuration();
        responseModel.licenseTypes = Context.licenseGateway.findLicensesForUserAndCodecast(loggedInUser, codecast)
                .stream().map(License::getLicenseType).toList();
        return responseModel;
    }
}

