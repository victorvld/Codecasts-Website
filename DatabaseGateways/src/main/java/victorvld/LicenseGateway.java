package victorvld;

import victorvld.entities.Codecast;
import victorvld.entities.License;
import victorvld.entities.User;

import java.util.List;

public interface LicenseGateway {
    License save(License license);

    List<License> findLicensesForUserAndCodecast(User user, Codecast codecast);
}
