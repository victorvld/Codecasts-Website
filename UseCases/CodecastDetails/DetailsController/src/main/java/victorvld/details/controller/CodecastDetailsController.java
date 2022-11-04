package victorvld.details.controller;

import victorvld.controller.Controller;
import victorvld.requestor.factory.UseCaseFactory;
import victorvld.requestor.request.Request;
import victorvld.requestor.usecase.UseCase;

public class CodecastDetailsController implements Controller {

    private UseCase useCase;

    public CodecastDetailsController(UseCaseFactory factory) {
        this.useCase = factory.make("CodecastDetails");
    }

    @Override
    public String handle(Request request) {
        return useCase.execute(request);
    }
}
