package cleancoderscom.context;

import cleancoderscom.CodeCastGateway;
import cleancoderscom.GateKeeper;
import cleancoderscom.LicenseGateway;
import cleancoderscom.UserGateway;

public class Context {

    //This is a global and a singleton
    public static CodeCastGateway codecastGateway;
    public static UserGateway userGateway;
    public static LicenseGateway licenseGateway;

    public static GateKeeper gateKeeper;

}
