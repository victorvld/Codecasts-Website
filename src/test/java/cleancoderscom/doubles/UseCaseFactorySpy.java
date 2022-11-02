package cleancoderscom.doubles;

import cleancoderscom.usecases.UseCase;
import cleancoderscom.usecases.UseCaseFactory;

public class UseCaseFactorySpy implements UseCaseFactory {
    public boolean makeWasCalled = false;

    @Override
    public UseCase make(String codecastSummaries) {
        makeWasCalled = true;
        return new DummyUseCase();
    }
}
