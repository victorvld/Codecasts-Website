package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.Context;
import cleancoderscom.http.Controller;
import cleancoderscom.http.ParsedRequest;
import cleancoderscom.usecases.Request;
import cleancoderscom.usecases.RequestBuilder;
import cleancoderscom.usecases.UseCase;
import cleancoderscom.usecases.UseCaseFactory;

import java.util.HashMap;

public class CodecastDetailsController implements Controller {

    private UseCaseFactory factory;
    private RequestBuilder builder;
    private UseCase useCase;
    private CodecastDetailsOutputBoundary presenter;
    private CodecastDetailsView view;

    public CodecastDetailsController(UseCaseFactory factory, RequestBuilder builder) {
        this.factory = factory;
        this.builder = builder;
        this.useCase = factory.make("CodecastDetails");
    }

    @Override
    public String handle(ParsedRequest request) {
        HashMap<String, String> args = new HashMap<>();
        args.put("User", Context.gateKeeper.getLoggedInUser().getUserName());
        args.put("Permalink", request.parsedPath.value);
        Request detailsRequest = builder.build("CodecastDetailsRequest", args);
        // detailsRequest.userName = Context.gateKeeper.getLoggedInUser().getUserName();
        // detailsRequest.permalink = request.parsedPath.value;
        return useCase.execute(detailsRequest);
        //return view.generateView(presenter.getViewModel());
    }
}
