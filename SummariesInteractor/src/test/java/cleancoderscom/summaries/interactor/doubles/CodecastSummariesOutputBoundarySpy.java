package cleancoderscom.summaries.interactor.doubles;

import cleancoderscom.CodecastSummariesOutputBoundary;
import cleancoderscom.CodecastSummariesResponse;

public class CodecastSummariesOutputBoundarySpy implements CodecastSummariesOutputBoundary {
    public CodecastSummariesResponse response;

    @Override
    public String present(CodecastSummariesResponse response) {
        this.response = response;
        return "TILT";
    }
}
