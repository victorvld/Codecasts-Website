package victorvld.entities;

import java.util.Objects;

public class Entity implements Cloneable{
    private String id;

    public Boolean isSame(Entity entity) {
        return id != null && Objects.equals(id, entity.id);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String userId) {
        this.id = userId;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
