package cleancoders.implementations;

import cleancoderscom.context.Context;
import cleancoderscom.interactor.DetailsRequest;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.summaries.interactor.SummariesRequest;

import java.util.HashMap;

public class RequestBuilderImpl implements cleancoderscom.requestor.builder.RequestBuilder {
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
