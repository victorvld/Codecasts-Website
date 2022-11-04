package victorvld.interactor.doubles;

import victorvld.interactor.DetailsRequest;
import victorvld.requestor.request.Request;
import victorvld.requestor.usecase.UseCase;

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
