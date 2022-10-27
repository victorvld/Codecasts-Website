package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.Context;
import cleancoderscom.http.Controller;
import cleancoderscom.http.ParsedRequest;

public class CodecastSummariesController implements Controller {

    private CodecastSummaryInputBoundary useCase;
    private CodecastSummariesOutputBoundary presenter;
    private CodecastSummariesView view;

    public CodecastSummariesController(CodecastSummaryInputBoundary useCase,
                                       CodecastSummariesOutputBoundary presenter,
                                       CodecastSummariesView view) {
        this.useCase = useCase;
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public String handle(ParsedRequest request) {
        useCase.summarizeCodecasts(Context.gateKeeper.getLoggedInUser(), presenter);
        return view.generateView(presenter.getViewModel());
    }
}
