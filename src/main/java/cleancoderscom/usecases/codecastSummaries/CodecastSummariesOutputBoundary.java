package cleancoderscom.usecases.codecastSummaries;

public interface CodecastSummariesOutputBoundary {
    CodecastSummariesViewModel getViewModel();

    String present(CodecastSummariesResponseModel responseModel);
}
