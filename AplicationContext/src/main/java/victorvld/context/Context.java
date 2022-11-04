package victorvld.context;

import victorvld.CodeCastGateway;
import victorvld.LicenseGateway;
import victorvld.UserGateway;
import victorvld.GateKeeper;

public class Context {

    //This is a global and a singleton
    public static CodeCastGateway codecastGateway;
    public static UserGateway userGateway;
    public static LicenseGateway licenseGateway;

    public static GateKeeper gateKeeper;

}
