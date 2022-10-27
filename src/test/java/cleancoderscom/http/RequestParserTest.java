package cleancoderscom.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestParserTest {

    // Degenerative tests first
    @Test
    void emptyRequest() {
        RequestParser parser = new RequestParser();
        ParsedRequest r = parser.parse("");
        Assertions.assertEquals("", r.method);
        Assertions.assertEquals("", r.path);
    }

    @Test
    void nullRequest() {
        RequestParser parser = new RequestParser();
        ParsedRequest r = parser.parse(null);
        Assertions.assertEquals("", r.method);
        Assertions.assertEquals("", r.path);
    }

    @Test
    void requestNonEmptyRequest() {
        RequestParser parser = new RequestParser();
        ParsedRequest r = parser.parse("GET /foo/bar HTTP/1.1");
        Assertions.assertEquals("GET", r.method);
        Assertions.assertEquals("/foo/bar", r.path);
    }

    @Test
    void partialRequest() {
        RequestParser parser = new RequestParser();
        ParsedRequest r = parser.parse("GET");
        Assertions.assertEquals("GET", r.method);
        Assertions.assertEquals("", r.path);
    }

}