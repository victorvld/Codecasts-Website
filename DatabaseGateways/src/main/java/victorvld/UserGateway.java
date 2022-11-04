package victorvld;

import victorvld.entities.User;

public interface UserGateway {
    User save(User user);

    User findUser(String username);
}
