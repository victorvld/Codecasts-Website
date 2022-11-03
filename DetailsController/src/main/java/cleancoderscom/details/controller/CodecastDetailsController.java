package cleancoderscom.details.controller;

import cleancoderscom.context.Context;
import cleancoderscom.http.Controller;
import cleancoderscom.http.ParsedRequest;
import cleancoderscom.requestor.builder.RequestBuilder;
import cleancoderscom.requestor.factory.UseCaseFactory;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.requestor.usecase.UseCase;


import java.util.HashMap;

public class CodecastDetailsController implements Controller {

    private UseCaseFactory factory;
    private RequestBuilder builder;
    private UseCase useCase;

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
        return useCase.execute(detailsRequest);
    }
}
