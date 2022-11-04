package victorvld.strategies.parsers;

import victorvld.strategies.SimpleRequestParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SimpleRequestParserTest {

    private final SimpleRequestParser parser = new SimpleRequestParser();

    private static Stream<Arguments> testRequest() {
        return Stream.of(
                Arguments.of(null, "", ""),
                Arguments.of("", "", ""),
                Arguments.of("GET", "GET", ""),
                Arguments.of("GET /foo/bar HTTP/1.1", "GET", "/foo/bar")
        );
    }

    @ParameterizedTest
    @MethodSource
    void testRequest(String request, String expectedMethod, String expectedPath) {
        var r = parser.parse(request);

        Assertions.assertEquals(expectedMethod, r.method);
        Assertions.assertEquals(expectedPath, r.path.fullPath);
    }
}
