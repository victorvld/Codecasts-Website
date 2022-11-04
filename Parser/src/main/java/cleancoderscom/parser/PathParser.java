package cleancoderscom.parser;

public class PathParser {
    public Path parse(String path) {
        Path requestPath = new Path(path);
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
