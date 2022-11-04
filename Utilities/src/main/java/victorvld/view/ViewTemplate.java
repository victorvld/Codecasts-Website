package victorvld.view;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewTemplate {
    private String template;

    public static ViewTemplate create(String templateResource) throws IOException {
        URL frontPageUrl = ClassLoader.getSystemResource(templateResource);
        byte[] frontPageBytes = Files.readAllBytes(Paths.get(frontPageUrl.getPath()));
        return new ViewTemplate(new String(frontPageBytes));
    }

    public ViewTemplate(String template) {
        this.template = template;
    }

    public void replace(String tagName, String content) {
        template = template.replace("${" + tagName + "}", content);
    }

    public String getContent() {
        return template;
    }
}
