package cleancoderscom.entities;

public class License extends Entity {

    public enum LicenseType {VIEWING, DOWNLOADING}

    private LicenseType licenseType;
    private User user;
    private Codecast codecast;

    public License(LicenseType type, User user, Codecast codecast) {
        this.licenseType = type;
        this.user = user;
        this.codecast = codecast;
    }

    public Codecast getCodecast() {
        return codecast;
    }

    public User getUser() {
        return user;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }
}
