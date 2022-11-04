package cleancoderscom.interactor.doubles;

import cleancoderscom.interactor.DetailsRequest;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.requestor.usecase.UseCase;

public class CodecastDetailsInputBoundarySpy implements UseCase {
    public boolean detailCodecastWasCalled;
    public DetailsRequest request;

    @Override
    public String execute(Request request) {
        this.request = (DetailsRequest) request;
        this.detailCodecastWasCalled = true;
        return "TILT";
    }
}
