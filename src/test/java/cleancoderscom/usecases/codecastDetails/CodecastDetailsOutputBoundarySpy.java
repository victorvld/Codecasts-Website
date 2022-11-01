package cleancoderscom.usecases.codecastDetails;

public class CodecastDetailsOutputBoundarySpy implements CodecastDetailsOutputBoundary {
    public CodecastDetailsResponseModel responseModel;
    public CodecastDetailsViewModel viewModel;

    @Override
    public CodecastDetailsViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public void present(CodecastDetailsResponseModel responseModel) {
        this.responseModel = responseModel;
    }
}