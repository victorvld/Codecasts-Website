package cleancoderscom.usecases;

import java.util.HashMap;

public interface RequestBuilder {

    Request build(String requestName, HashMap<String,String> args);
}
