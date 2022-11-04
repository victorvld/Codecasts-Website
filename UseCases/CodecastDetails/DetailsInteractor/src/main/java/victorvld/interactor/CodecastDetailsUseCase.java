package victorvld.interactor;

import victorvld.entities.Codecast;
import victorvld.responder.CodecastDetailsOutputBoundary;
import victorvld.context.Context;
import victorvld.entities.License;
import victorvld.entities.User;
import victorvld.requestor.request.Request;
import victorvld.requestor.usecase.UseCase;

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

