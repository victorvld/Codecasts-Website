package cleancoderscom.view.doubles;

import cleancoderscom.view.CodecastDetailsView;
import cleancoderscom.view.CodecastDetailsViewModel;

public class CodecastDetailsViewSpy implements CodecastDetailsView {
    public boolean generateViewWasCalled;
    public CodecastDetailsViewModel view;

    @Override
    public String generateView(CodecastDetailsViewModel view) {
        this.generateViewWasCalled = true;
        this.view = view;
        return null;
    }
}
