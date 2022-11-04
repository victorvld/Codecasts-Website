package cleancoders;

import cleancoders.configurations.WebServerConfiguration;
import cleancoders.implementations.WebServiceImpl;
import cleancoderscom.context.setup.TestSetup;
import cleancoderscom.socketserver.SocketServer;
import cleancoderscom.socketserver.SocketService;

public class Main {
    private static final int port = 8080;

    public static void main(String[] args) throws Exception {
        TestSetup.setupSampleData();
        initWebServer();
    }

    private static void initWebServer() throws Exception {
        var service = setUpService();
        var server = new SocketServer(service, port);
        server.start();
    }

    private static SocketService setUpService() {
        return new WebServiceImpl(new WebServerConfiguration());
    }

}
