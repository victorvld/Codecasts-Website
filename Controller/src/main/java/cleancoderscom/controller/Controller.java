package cleancoderscom.controller;

import cleancoderscom.requestor.request.Request;

public interface Controller {

    public String handle(Request request);
}
