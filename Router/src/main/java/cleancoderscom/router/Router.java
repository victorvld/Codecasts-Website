package cleancoderscom.router;

import cleancoderscom.controller.Controller;
import cleancoderscom.requestor.request.Request;

import java.util.HashMap;
import java.util.Map;

public class Router {

    private final Map<String, Controller> routes = new HashMap<>();

    public void addRoute(String key, Controller controller) {
        this.routes.put(key, controller);

    }

    public String route(Request request) {
        Controller controller = this.routes.get(request.getName());
        if (controller == null) {
            return "HTTP/1.1 404 OK\n";
        } else {
            return controller.handle(request);
        }
    }
}
