package cleancoderscom.http;

public class RequestParser {


    // In real life, here you will write a parser that parse an InputStream. You don't want to parse the body directly.
    // Instead, you want to parse the header first, and then you decide what to do with the body.
    public ParsedRequest parse(String requestString) {
        ParsedRequest request = new ParsedRequest();
        RequestPathParser pathParser = new RequestPathParser();
        if (requestString != null) {
            String[] parts = requestString.split(" ");
            if (parts.length >= 1) {
                request.method = parts[0];
            }
            if (parts.length >= 2) {
                request.parsedPath = pathParser.parse(parts[1]);
            }
            return request;
        }
        return request;
    }
}
