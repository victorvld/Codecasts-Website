package cleancoderscom.utilities;

import cleancoderscom.TestSetup;
import cleancoderscom.http.ParsedRequest;
import cleancoderscom.http.RequestParser;
import cleancoderscom.http.Router;
import cleancoderscom.socketserver.SocketServer;
import cleancoderscom.usecases.RequestBuilder;
import cleancoderscom.usecases.UseCaseFactory;
import cleancoderscom.usecases.UseCaseFactoryImpl;
import cleancoderscom.usecases.codecastDetails.CodecastDetailsController;
import cleancoderscom.usecases.codecastDetails.CodecastDetailsRequestBuilder;
import cleancoderscom.usecases.codecastSummaries.CodecastSummariesController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public Main() {
        TestSetup.setupSampleData();
    }

    public static void main(String[] args) throws Exception {
        TestSetup.setupSampleData();
        Router router = new Router();
        UseCaseFactory factory = new UseCaseFactoryImpl();
        router.addPath("", new CodecastSummariesController(factory));
        RequestBuilder builder = new CodecastDetailsRequestBuilder();
        router.addPath("episode", new CodecastDetailsController(factory, builder));

        SocketServer server = new SocketServer(s -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                ParsedRequest request = new RequestParser().parse(reader.readLine());
                String response = router.route(request);
                s.getOutputStream().write(response.getBytes());
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 8080);
        server.start();
    }

}
