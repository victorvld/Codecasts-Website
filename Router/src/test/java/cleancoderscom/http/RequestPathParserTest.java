package cleancoderscom.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestPathParserTest {

    @Test
    void testSimplePath() {
        String path = "/";
        RequestPathParser pathParser = new RequestPathParser();

        RequestPath requestPath = pathParser.parse(path);

        Assertions.assertEquals(requestPath.dir, "");
        Assertions.assertEquals(requestPath.value, "");
        Assertions.assertEquals(requestPath.action, "");
    }

    @Test
    void testPathDirectory() {
        String path = "/episode";
        RequestPathParser pathParser = new RequestPathParser();

        RequestPath requestPath = pathParser.parse(path);

        Assertions.assertEquals(requestPath.dir, "episode");
        Assertions.assertEquals(requestPath.value, "");
        Assertions.assertEquals(requestPath.action, "");
    }

    @Test
    void testDynamicPath() {
        String path = "/episode/e1/show";
        RequestPathParser pathParser = new RequestPathParser();

        RequestPath requestPath = pathParser.parse(path);

        Assertions.assertEquals(requestPath.dir, "episode");
        Assertions.assertEquals(requestPath.value, "e1");
        Assertions.assertEquals(requestPath.action, "show");
    }
}