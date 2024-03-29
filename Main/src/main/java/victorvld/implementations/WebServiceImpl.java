package victorvld.implementations;

import victorvld.configurations.WebServerConfiguration;
import victorvld.socketserver.SocketService;
import victorvld.requestor.request.Request;
import victorvld.adapters.ParsedRequestAdapter;
import victorvld.parser.RequestParser;
import victorvld.router.Router;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WebServiceImpl implements SocketService {
    private final ParsedRequestAdapter adapter;
    private final RequestParser parser;
    private final Router router;

    public WebServiceImpl(WebServerConfiguration configuration) {
        this.adapter = configuration.getAdapter();
        this.parser = configuration.getParser();
        this.router = configuration.getRouter();
    }

    @Override
    public void serve(Socket s) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            Request request = adapter.createRequest(parser.parse(reader.readLine()));
            String response = router.route(request);
            s.getOutputStream().write(response.getBytes());
            s.close();
        } catch (IOException e) {
            // TODO: handle exceptions properly.
            e.printStackTrace();
        }
    }
}
