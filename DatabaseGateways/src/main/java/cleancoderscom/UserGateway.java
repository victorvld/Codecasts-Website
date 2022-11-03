package cleancoderscom;

import cleancoderscom.entities.User;

public interface UserGateway {
    User save(User user);

    User findUser(String username);
}
