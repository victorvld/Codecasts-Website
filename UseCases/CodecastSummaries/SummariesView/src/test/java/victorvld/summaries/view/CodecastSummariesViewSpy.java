package victorvld.summaries.view;

public class CodecastSummariesViewSpy implements CodecastSummariesView {
    public boolean generateViewWasCalled = false;
    public CodecastSummariesViewModel viewModel;

    @Override
    public String generateView(CodecastSummariesViewModel viewModel) {
        this.viewModel = viewModel;
        this.generateViewWasCalled = true;
        return null;
    }
}
