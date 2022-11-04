package victorvld.interactor;

import victorvld.requestor.request.Request;

public class SummariesRequest implements Request {
    public String userName;

    @Override
    public String getName() {
        return "summaries";
    }
}
