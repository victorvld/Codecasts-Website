package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.http.Controller;
import cleancoderscom.http.ParsedRequest;
import cleancoderscom.usecases.UseCase;
import cleancoderscom.usecases.UseCaseFactory;

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
