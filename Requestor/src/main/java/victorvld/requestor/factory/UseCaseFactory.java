package victorvld.requestor.factory;

import victorvld.requestor.usecase.UseCase;

public interface UseCaseFactory {
    UseCase make(String useCaseName);
}
