package cleancoderscom.context.doubles;

import cleancoderscom.requestor.builder.RequestBuilder;
import cleancoderscom.requestor.request.Request;

import java.util.HashMap;

public class RequestBuilderSpy implements RequestBuilder {
    public boolean buildWasCalled = false;

    @Override
    public Request build(String requestName, HashMap<String, String> args) {
        buildWasCalled = true;
        return null;
    }
}
