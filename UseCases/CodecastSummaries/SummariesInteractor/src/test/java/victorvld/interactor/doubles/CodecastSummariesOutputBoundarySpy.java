package victorvld.interactor.doubles;

import victorvld.CodecastSummariesOutputBoundary;
import victorvld.CodecastSummariesResponse;

public class CodecastSummariesOutputBoundarySpy implements CodecastSummariesOutputBoundary {
    public CodecastSummariesResponse response;

    @Override
    public String present(CodecastSummariesResponse response) {
        this.response = response;
        return "TILT";
    }
}
