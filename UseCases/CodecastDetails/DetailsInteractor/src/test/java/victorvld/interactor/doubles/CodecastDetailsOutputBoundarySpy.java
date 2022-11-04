package victorvld.interactor.doubles;

import victorvld.responder.CodecastDetailsOutputBoundary;
import victorvld.responder.CodecastDetailsResponse;

public class CodecastDetailsOutputBoundarySpy implements CodecastDetailsOutputBoundary {
    public CodecastDetailsResponse response;

    @Override
    public String present(CodecastDetailsResponse response) {
        this.response = response;
        return "TILT";
    }
}
