package cleancoderscom.view;

import cleancoderscom.view.ViewTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ViewTemplateTest {

    // Starting off from the most degenerative tests
    @Test
    void noReplacements() {
        String content = "some static content";
        ViewTemplate template = new ViewTemplate(content);

        Assertions.assertEquals(template.getContent(), content);
    }

    @Test
    void simpleReplacement() {
        ViewTemplate template = new ViewTemplate("replace ${this}.");

        template.replace("this", "replacement");

        Assertions.assertEquals("replace replacement.", template.getContent());
    }
}