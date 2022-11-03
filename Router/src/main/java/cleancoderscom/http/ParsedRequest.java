package cleancoderscom.http;

public class ParsedRequest {

    public RequestPath parsedPath = new RequestPath("");
    public String method = "";

    public ParsedRequest() {
    }

    public ParsedRequest(String method, String path) {
        this.method = method;
        this.parsedPath = new RequestPathParser().parse(path);
    }


}
