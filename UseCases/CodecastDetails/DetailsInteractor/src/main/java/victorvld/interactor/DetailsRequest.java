package victorvld.interactor;

import victorvld.requestor.request.Request;

public class DetailsRequest implements Request {
    public String permalink;
    public String userName;

    @Override
    public String getName() {
        return "details";
    }
}
