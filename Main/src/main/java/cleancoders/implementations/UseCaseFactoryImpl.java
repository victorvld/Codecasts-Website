package cleancoders.implementations;

import cleancoderscom.summaries.view.CodecastSummariesPresenter;
import cleancoderscom.summaries.view.CodecastSummariesViewImpl;
import cleancoderscom.interactor.CodecastDetailsUseCase;
import cleancoderscom.requestor.factory.UseCaseFactory;
import cleancoderscom.requestor.usecase.UseCase;
import cleancoderscom.summaries.interactor.CodecastSummariesUseCase;
import cleancoderscom.view.CodecastDetailsPresenter;
import cleancoderscom.view.CodecastDetailsViewImpl;

public class UseCaseFactoryImpl implements UseCaseFactory {
    @Override
    public UseCase make(String codecastSummaries) {

        return switch (codecastSummaries) {
            case "CodecastSummaries" -> new CodecastSummariesUseCase(new CodecastSummariesPresenter(new CodecastSummariesViewImpl()));
            case "CodecastDetails" -> new CodecastDetailsUseCase(new CodecastDetailsPresenter(new CodecastDetailsViewImpl()));
            default -> new CodecastSummariesUseCase(new CodecastSummariesPresenter(new CodecastSummariesViewImpl()));
        };
    }
}
