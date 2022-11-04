package cleancoderscom.summaries.interactor;

import cleancoderscom.requestor.request.Request;

public class SummariesRequest implements Request {
    public String userName;

    @Override
    public String getName() {
        return "summaries";
    }
}
