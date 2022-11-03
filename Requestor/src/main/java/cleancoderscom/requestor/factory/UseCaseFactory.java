package cleancoderscom.requestor.factory;

import cleancoderscom.requestor.usecase.UseCase;

public interface UseCaseFactory {
    UseCase make(String useCaseName);
}
