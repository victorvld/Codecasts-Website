package cleancoderscom.details.controller;

import cleancoderscom.controller.Controller;
import cleancoderscom.requestor.factory.UseCaseFactory;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.requestor.usecase.UseCase;

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
