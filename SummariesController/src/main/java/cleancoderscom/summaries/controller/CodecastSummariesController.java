package cleancoderscom.summaries.controller;

import cleancoderscom.controller.Controller;
import cleancoderscom.requestor.factory.UseCaseFactory;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.requestor.usecase.UseCase;

public class CodecastSummariesController implements Controller {

    private UseCase useCase;

    public CodecastSummariesController(UseCaseFactory factory) {
        this.useCase = factory.make("CodecastSummaries");
    }

    @Override
    public String handle(Request request) {
        return useCase.execute(request);
    }

}
