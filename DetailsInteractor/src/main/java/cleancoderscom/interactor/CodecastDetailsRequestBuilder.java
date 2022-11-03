package cleancoderscom.interactor;

import cleancoderscom.requestor.builder.RequestBuilder;
import cleancoderscom.requestor.request.Request;

import java.util.HashMap;

public class CodecastDetailsRequestBuilder implements RequestBuilder {
    @Override
    public Request build(String requestName, HashMap<String, String> args) {
        DetailsRequest request = new DetailsRequest();
        request.permalink = args.get("Permalink");
        return request;
    }
}
