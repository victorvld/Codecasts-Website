package cleancoderscom.summaries.controller;

import cleancoderscom.requestor.factory.UseCaseFactory;
import cleancoderscom.http.Controller;
import cleancoderscom.http.ParsedRequest;
import cleancoderscom.requestor.usecase.UseCase;

public class CodecastSummariesController implements Controller {

    private UseCase useCase;

    public CodecastSummariesController(UseCaseFactory factory) {
        this.useCase = factory.make("CodecastSummaries");
    }

    @Override
    public String handle(ParsedRequest request) {
        return useCase.execute(null);
    }

}
