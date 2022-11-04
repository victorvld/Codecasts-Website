package victorvld;

import victorvld.configurations.WebServerConfiguration;
import victorvld.context.setup.TestSetup;
import victorvld.implementations.WebServiceImpl;
import victorvld.socketserver.SocketServer;
import victorvld.socketserver.SocketService;

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
