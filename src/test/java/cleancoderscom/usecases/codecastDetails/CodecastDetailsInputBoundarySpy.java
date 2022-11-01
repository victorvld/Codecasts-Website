package cleancoderscom.usecases.codecastDetails;

public class CodecastDetailsInputBoundarySpy implements CodecastDetailsInputBoundary {
    public boolean detailCodecastWasCalled;
    public CodecastDetailsOutputBoundary outputBoundary;
    public CodecastDetailsRequest request;

    @Override
    public void detailCodecasts(CodecastDetailsRequest request, CodecastDetailsOutputBoundary presenter) {
        this.request = request;
        this.detailCodecastWasCalled = true;
        this.outputBoundary = presenter;
    }
}
