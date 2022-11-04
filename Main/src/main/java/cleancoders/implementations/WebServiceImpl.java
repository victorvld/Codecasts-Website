package cleancoders.implementations;

import cleancoders.configurations.WebServerConfiguration;
import cleancoders.adapters.ParsedRequestAdapter;
import cleancoderscom.parser.RequestParser;
import cleancoderscom.requestor.request.Request;
import cleancoderscom.router.Router;
import cleancoderscom.socketserver.SocketService;

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
