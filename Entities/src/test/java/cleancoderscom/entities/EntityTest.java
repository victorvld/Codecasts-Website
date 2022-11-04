package cleancoderscom.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EntityTest {

    @Test
    public void oneEntityIsTheSameAsItself() {
        Entity e1 = new Entity();
        e1.setId("e1ID");

        Assertions.assertTrue(e1.isSame(e1));
    }

    @Test
    public void usersWithTheSameIdAreTheSame() {
        Entity e1 = new Entity();
        Entity e2 = new Entity();

        e1.setId("e1ID");
        e2.setId("e1ID");

        Assertions.assertTrue(e1.isSame(e2));
    }

    @Test
    public void usersWithNullIdsAreNeverSame() {
        Entity e1 = new Entity();
        Entity e2 = new Entity();

        Assertions.assertFalse(e1.isSame(e2));
    }
}