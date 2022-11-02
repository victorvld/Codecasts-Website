package cleancoderscom;

import cleancoderscom.gateways.CodeCastGateway;
import cleancoderscom.gateways.LicenseGateway;
import cleancoderscom.gateways.UserGateway;

import java.net.Socket;

public class Context {

    //This is a global and a singleton
    public static CodeCastGateway codecastGateway;
    public static UserGateway userGateway;
    public static LicenseGateway licenseGateway;

    public static GateKeeper gateKeeper;

}
