package cleancoderscom.context.doubles;

import cleancoderscom.requestor.factory.UseCaseFactory;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.requestor.usecase.UseCase;

public class UseCaseFactorySpy implements UseCaseFactory {
    public boolean makeWasCalled = false;

    @Override
    public UseCase make(String codecastSummaries) {
        makeWasCalled = true;
        return new DummyUseCase();
    }

    private class DummyUseCase implements UseCase {

        @Override
        public String execute(Request request) {
            return "TILT";
        }
    }
}
