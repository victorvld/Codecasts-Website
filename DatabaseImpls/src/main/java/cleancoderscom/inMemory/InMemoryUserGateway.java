package cleancoderscom.inMemory;

import cleancoderscom.entities.User;
import cleancoderscom.UserGateway;

public class InMemoryUserGateway extends GatewayUtilities<User> implements UserGateway {

    @Override
    public User findUser(String userName) {
        for (User user : getEntities()) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}