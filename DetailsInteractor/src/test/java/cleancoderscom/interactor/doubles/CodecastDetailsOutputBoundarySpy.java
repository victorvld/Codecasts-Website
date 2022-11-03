package cleancoderscom.interactor.doubles;

import cleancoderscom.responder.CodecastDetailsOutputBoundary;
import cleancoderscom.responder.CodecastDetailsResponse;

public class CodecastDetailsOutputBoundarySpy implements CodecastDetailsOutputBoundary {
    public CodecastDetailsResponse response;

    @Override
    public String present(CodecastDetailsResponse response) {
        this.response = response;
        return "TILT";
    }
}
