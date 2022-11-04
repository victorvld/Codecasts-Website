package victorvld.controller;

import victorvld.requestor.factory.UseCaseFactory;
import victorvld.requestor.request.Request;
import victorvld.requestor.usecase.UseCase;

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
