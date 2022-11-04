package victorvld.entities;

public class User extends Entity {

    private String userName;

    public User(String username) {
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

}
