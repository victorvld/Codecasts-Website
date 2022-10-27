package cleancoderscom.utilities;

import cleancoderscom.http.ParsedRequest;
import cleancoderscom.http.RequestParser;
import cleancoderscom.http.Router;
import cleancoderscom.socketserver.SocketServer;
import cleancoderscom.TestSetup;
import cleancoderscom.usecases.codecastSummaries.CodecastSummariesController;
import cleancoderscom.usecases.codecastSummaries.CodecastSummariesPresenter;
import cleancoderscom.usecases.codecastSummaries.CodecastSummariesViewImpl;
import cleancoderscom.usecases.codecastSummaries.CodecastSummaryUseCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public Main() {
        TestSetup.setupSampleData();
    }

    public static void main(String[] args) throws Exception {
        Router router = new Router();
        CodecastSummariesViewImpl view = new CodecastSummariesViewImpl();
        CodecastSummariesPresenter presenter = new CodecastSummariesPresenter();
        CodecastSummaryUseCase useCase = new CodecastSummaryUseCase();
        router.addPath("", new CodecastSummariesController(useCase, presenter, view));
        // TODO: 22/10/22 : Add this controller 
        //router.addPath("", new CodecasrDetailsController);

        TestSetup.setupSampleData();
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
