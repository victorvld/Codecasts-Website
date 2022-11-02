package cleancoderscom.doubles;

import cleancoderscom.usecases.Request;
import cleancoderscom.usecases.RequestBuilder;

import java.util.HashMap;

public class RequestBuilderSpy implements RequestBuilder {
    public boolean buildWasCalled = false;

    @Override
    public Request build(String requestName, HashMap<String, String> args) {
        buildWasCalled = true;
        return null;
    }
}
