package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.usecases.Request;
import cleancoderscom.usecases.RequestBuilder;

import java.util.HashMap;

public class CodecastDetailsRequestBuilder implements RequestBuilder {
    @Override
    public Request build(String requestName, HashMap<String, String> args) {
        DetailsRequest request = new DetailsRequest();
        request.permalink = args.get("Permalink");
        return request;
    }
}
