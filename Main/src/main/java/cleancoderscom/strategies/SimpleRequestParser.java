package cleancoderscom.strategies;

import cleancoderscom.parser.ParsedRequest;
import cleancoderscom.parser.Path;
import cleancoderscom.parser.RequestParser;

public class SimpleRequestParser implements RequestParser {

    public static final String SEPARATOR = " ";

    public ParsedRequest parse(String requestString) {
        ParsedRequest request = new ParsedRequest();
        PathParser pathParser = new PathParser();
        if (requestString != null) {
            String[] parts = requestString.split(SEPARATOR);
            if (parts.length >= 1) {
                request.method = parts[0];
            }
            if (parts.length >= 2) {
                request.path = pathParser.parse(parts[1]);
            }
            return request;
        }
        return request;
    }

    public static class PathParser {

        public static final String SEPARATOR = "/";

        public Path parse(String path) {
            Path requestPath = new Path();
            requestPath.fullPath = path;
            if (path != null) {
                String[] parts = path.split(SEPARATOR);
                if (parts.length > 1) {
                    requestPath.dir = parts[1];
                    if (parts.length > 2) {
                        requestPath.value = parts[2];
                        if (parts.length > 3) {
                            requestPath.action = parts[3];
                        }
                    }
                }
            }
            return requestPath;
        }
    }
}
