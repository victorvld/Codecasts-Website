package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.entities.User;

public class CodecastSummariesInputBoundarySpy implements CodecastSummaryInputBoundary {
    public boolean summarizeCodecastWasCalled = false;
    public User requestedUser;
    public CodecastSummariesOutputBoundary outputBoundary;

    @Override
    public void summarizeCodecasts(User loggedInUser, CodecastSummariesOutputBoundary presenter) {
        summarizeCodecastWasCalled = true;
        requestedUser = loggedInUser;
        outputBoundary = presenter;
    }
}
