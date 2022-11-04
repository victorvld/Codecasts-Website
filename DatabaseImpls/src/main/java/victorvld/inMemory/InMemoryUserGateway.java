package victorvld.inMemory;

import victorvld.UserGateway;
import victorvld.entities.User;

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