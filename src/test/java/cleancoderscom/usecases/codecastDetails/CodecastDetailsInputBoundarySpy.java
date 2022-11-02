package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.usecases.Request;
import cleancoderscom.usecases.UseCase;

public class CodecastDetailsInputBoundarySpy implements UseCase {
    public boolean detailCodecastWasCalled;
    public CodecastDetailsOutputBoundary outputBoundary;
    public DetailsRequest request;

    @Override
    public String execute(Request request) {
        this.request = (DetailsRequest) request;
        this.detailCodecastWasCalled = true;
        return "TILT";
    }
}
