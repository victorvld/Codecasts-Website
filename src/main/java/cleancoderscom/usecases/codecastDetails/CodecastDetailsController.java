package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.Context;
import cleancoderscom.http.Controller;
import cleancoderscom.http.ParsedRequest;

public class CodecastDetailsController implements Controller {

    private CodecastDetailsInputBoundary useCase;
    private CodecastDetailsOutputBoundary presenter;
    private CodecastDetailsView view;

    public CodecastDetailsController(CodecastDetailsInputBoundary useCase,
                                     CodecastDetailsOutputBoundary presenter,
                                     CodecastDetailsView view) {
        this.useCase = useCase;
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public String handle(ParsedRequest request) {
        CodecastDetailsRequest detailsRequest = new CodecastDetailsRequest();
        detailsRequest.userName = Context.gateKeeper.getLoggedInUser().getUserName();
        detailsRequest.permalink = request.parsedPath.value;
        useCase.detailCodecasts(detailsRequest, presenter);
        return view.generateView(presenter.getViewModel());
    }
}
