package cleancoderscom.parser;

public class ParsedRequest {

    public Path path = new Path("");
    public String method = "";

    public ParsedRequest() {
    }

    public ParsedRequest(String method, String path) {
        this.method = method;
        this.path = new PathParser().parse(path);
    }


}
