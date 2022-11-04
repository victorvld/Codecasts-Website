package cleancoderscom.http;

import cleancoderscom.controller.Controller;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.router.Router;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RouterTest {
//
//    private Request actualRequest;
//    private Router router;
//
//    @BeforeEach
//    public void setUp() {
//        router = new Router();
//    }
//
//    @Test
//    void rootPath() {
//        router.addRoute("", new TestController());
//        Request request = new ("GET", "/");
//
//        router.route(request);
//
//        Assertions.assertEquals(actualRequest, request);
//    }
//
//    @Test
//    void simplePath() {
//        router.addRoute("it", new TestController());
//        ParsedRequest request = new ParsedRequest("GET", "/it");
//
//        router.route(request);
//
//        Assertions.assertEquals(actualRequest, request);
//    }
//
//    @Test
//    void pathWithDynamicDate() {
//        router.addRoute("a", new TestController());
//        ParsedRequest request = new ParsedRequest("GET", "/a/b/c");
//
//        router.route(request);
//
//        Assertions.assertEquals(actualRequest, request);
//    }
//
//    @Test
//    void Four04() {
//        String response = router.route(new ParsedRequest("GET", "something-missing"));
//
//        Assertions.assertEquals("HTTP/1.1 404 OK\n", response);
//    }
//
//    class TestController implements Controller {
//
//        @Override
//        public String handle(ParsedRequest request) {
//            actualRequest = request;
//            return "";
//        }
//    }
}