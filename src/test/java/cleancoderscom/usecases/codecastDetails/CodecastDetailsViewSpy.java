package cleancoderscom.usecases.codecastDetails;

public class CodecastDetailsViewSpy implements CodecastDetailsView {
    public boolean generateViewWasCalled;
    public CodecastDetailsViewModel viewModel;

    @Override
    public String generateView(CodecastDetailsViewModel viewModel) {
        this.generateViewWasCalled = true;
        this.viewModel = viewModel;
        return null;
    }
}
