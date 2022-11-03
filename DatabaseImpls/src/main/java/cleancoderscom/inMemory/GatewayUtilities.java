package cleancoderscom.inMemory;

import cleancoderscom.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class GatewayUtilities<T extends Entity> {
    HashMap<String, T> entities = new HashMap<String, T>();

    protected List<T> getEntities() {
        List<T> result = new ArrayList<T>();
        for (T entity : entities.values()) {
            addCloneToList(result, entity);
        }
        return result;
    }

    private void addCloneToList(List<T> result, T entity) {
        try {
            result.add((T) entity.clone());
        } catch (CloneNotSupportedException e) {
            throw new UnclonnableEntity();
        }
    }

    public void delete(T entity) {
        entities.remove(entity.getId());
    }

    public T save(T entity) {
        if (entity.getId() == null) {
            // That's very ugly but enough for test propouse.
            entity.setId(UUID.randomUUID().toString());
        }
        putCloneInMap(entity);
        return entity;
    }

    private void putCloneInMap(T entity) {
        try {
            entities.put(entity.getId(), (T) entity.clone());
        } catch (CloneNotSupportedException e) {
            throw new UnclonnableEntity();
        }
    }

    private static class UnclonnableEntity extends RuntimeException {
    }
}
