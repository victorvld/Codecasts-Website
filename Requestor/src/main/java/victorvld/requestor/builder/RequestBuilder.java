package victorvld.requestor.builder;

import victorvld.requestor.request.Request;

import java.util.HashMap;

public interface RequestBuilder {

    Request build(String requestName, HashMap<String,String> args);
}
