package victorvld.inMemory;

import victorvld.LicenseGateway;
import victorvld.entities.Codecast;
import victorvld.entities.License;
import victorvld.entities.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLicenseGateway extends GatewayUtilities<License> implements LicenseGateway {

    @Override
    public List<License> findLicensesForUserAndCodecast(User user, Codecast codecast) {
        List<License> results = new ArrayList<>();
        for (License license : getEntities()) {
            if (license.getCodecast().isSame(codecast) && license.getUser().isSame(user)) {
                results.add(license);
            }
        }
        return results;
    }
}