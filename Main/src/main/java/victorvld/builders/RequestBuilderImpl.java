package victorvld.builders;

import victorvld.interactor.SummariesRequest;
import victorvld.requestor.request.Request;
import victorvld.context.Context;
import victorvld.interactor.DetailsRequest;
import victorvld.requestor.builder.RequestBuilder;

import java.util.HashMap;

public class RequestBuilderImpl implements RequestBuilder {
    @Override
    public Request build(String requestName, HashMap<String, String> args) {

        Request request;
        if (requestName.equals("CodecastDetailsRequest")) {
            var dr = new DetailsRequest();
            dr.userName = Context.gateKeeper.getLoggedInUser().getUserName();
            dr.permalink = args.get("permalink");
            request = dr;
        } else {
            var sr = new SummariesRequest();
            sr.userName = Context.gateKeeper.getLoggedInUser().getUserName();
            request = sr;
        }
        return request;
    }
}
