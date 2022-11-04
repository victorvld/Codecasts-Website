package victorvld.adapters;

import victorvld.requestor.builder.RequestBuilder;
import victorvld.requestor.request.Request;
import victorvld.parser.ParsedRequest;

import java.util.HashMap;

public class ParsedRequestAdapter {

    private final RequestBuilder builder;

    public ParsedRequestAdapter(RequestBuilder builder) {
        this.builder = builder;
    }

    public Request createRequest(ParsedRequest parsedRequest) {
        HashMap<String, String> args = extractRequestData(parsedRequest);
        String requestName = extractRequestName(parsedRequest);
        return builder.build(requestName, args);
    }

    private HashMap<String, String> extractRequestData(ParsedRequest parsedRequest) {
        HashMap<String, String> requestData = new HashMap<>();
        if ("episode".equals(parsedRequest.path.dir)) {
            requestData.put("permalink", parsedRequest.path.value);
        }
        return requestData;
    }

    private String extractRequestName(ParsedRequest parsedRequest) {
        if ("episode".equals(parsedRequest.path.dir)) {
            return "CodecastDetailsRequest";
        }
        return "CodecastSummariesRequest";
    }
}
