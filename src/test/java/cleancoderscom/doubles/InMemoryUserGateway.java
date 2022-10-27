package cleancoderscom.doubles;

import cleancoderscom.entities.User;
import cleancoderscom.gateways.UserGateway;

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