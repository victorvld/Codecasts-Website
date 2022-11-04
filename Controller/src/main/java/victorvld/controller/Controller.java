package victorvld.controller;

import victorvld.requestor.request.Request;

public interface Controller {

    public String handle(Request request);
}
