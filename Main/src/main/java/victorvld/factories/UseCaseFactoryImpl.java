package victorvld.factories;

import victorvld.interactor.CodecastSummariesUseCase;
import victorvld.requestor.factory.UseCaseFactory;
import victorvld.requestor.usecase.UseCase;
import victorvld.summaries.view.CodecastSummariesPresenter;
import victorvld.summaries.view.CodecastSummariesViewImpl;
import victorvld.interactor.CodecastDetailsUseCase;
import victorvld.view.CodecastDetailsPresenter;
import victorvld.view.CodecastDetailsViewImpl;

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
