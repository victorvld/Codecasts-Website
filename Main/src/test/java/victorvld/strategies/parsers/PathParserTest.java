package victorvld.strategies.parsers;

import victorvld.strategies.SimpleRequestParser;
import victorvld.parser.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PathParserTest {

    private final SimpleRequestParser.PathParser parser = new SimpleRequestParser.PathParser();
    ;

    private static Stream<Arguments> testPath() {
        return Stream.of(
                Arguments.of(null, "", "", ""),
                Arguments.of("", "", "", ""),
                Arguments.of("/", "", "", ""),
                Arguments.of("/dir", "dir", "", ""),
                Arguments.of("/dir/dir1", "dir", "dir1", ""),
                Arguments.of("/dir/dir1/action", "dir", "dir1", "action")
        );
    }

    @ParameterizedTest
    @MethodSource
    void testPath(String path, String expectedDir, String expectedValue, String expectedAction) {
        Path parsedPath = parser.parse(path);

        Assertions.assertEquals(parsedPath.fullPath, path);
        Assertions.assertEquals(parsedPath.dir, expectedDir);
        Assertions.assertEquals(parsedPath.value, expectedValue);
        Assertions.assertEquals(parsedPath.action, expectedAction);
    }
}