package victorvld.interactor;

import victorvld.CodecastSummariesResponse;
import victorvld.CodecastSummaryResponse;

import java.util.ArrayList;
import java.util.List;

public class CodecastSummariesResponseModel implements CodecastSummariesResponse {
    private final List<CodecastSummaryResponse> codecastSummaries;
    public CodecastSummariesResponseModel() {
        codecastSummaries = new ArrayList<>();
    }

    public List<CodecastSummaryResponse> getCodecastSummaries() {
        return codecastSummaries;
    }

    public void addCodecastSummary(CodecastSummary summary) {
        codecastSummaries.add(summary);
    }
}
