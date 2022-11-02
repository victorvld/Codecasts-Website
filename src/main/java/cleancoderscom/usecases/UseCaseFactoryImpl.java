package cleancoderscom.usecases;

import cleancoderscom.usecases.codecastSummaries.CodecastSummariesPresenter;
import cleancoderscom.usecases.codecastSummaries.CodecastSummariesUseCase;
import cleancoderscom.usecases.codecastSummaries.CodecastSummariesViewImpl;

public class UseCaseFactoryImpl implements UseCaseFactory {
    @Override
    public UseCase make(String codecastSummaries) {

        return switch (codecastSummaries) {
            case "CodecastSummaries" -> new CodecastSummariesUseCase(new CodecastSummariesPresenter(new CodecastSummariesViewImpl()));
            // case "CodecastDetails" -> new CodecastDetailsUseCase();
            default -> new CodecastSummariesUseCase(new CodecastSummariesPresenter(new CodecastSummariesViewImpl()));
        };
    }
}