package victorvld.context.doubles;

import victorvld.requestor.factory.UseCaseFactory;
import victorvld.requestor.request.Request;
import victorvld.requestor.usecase.UseCase;

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
