package cleancoderscom.doubles;

import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.License;
import cleancoderscom.gateways.LicenseGateway;
import cleancoderscom.entities.User;

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