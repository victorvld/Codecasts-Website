package cleancoderscom.http;

public class RequestPathParser {
    public RequestPath parse(String path) {
        RequestPath requestPath = new RequestPath(path);
        String[] parts = path.split("/");
        if (parts.length > 1) {
            requestPath.dir = parts[1];
            if (parts.length > 2) {
                requestPath.value = parts[2];
                if (parts.length > 3) {
                    requestPath.action = parts[3];
                }
            }
        }
        return requestPath;
    }
}
