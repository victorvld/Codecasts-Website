package cleancoderscom.usecases.codecastSummaries;

public class CodecastSummariesOutputBoundarySpy implements CodecastSummariesOutputBoundary {
    public CodecastSummariesViewModel viewModel;
    public CodecastSummariesResponseModel responseModel;

    @Override
    public CodecastSummariesViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public String present(CodecastSummariesResponseModel responseModel) {
        this.responseModel = responseModel;
        return "TILT";
    }
}
