package cleancoderscom.configurations;

import cleancoderscom.builders.RequestBuilderImpl;
import cleancoderscom.factories.UseCaseFactoryImpl;
import cleancoderscom.details.controller.CodecastDetailsController;
import cleancoderscom.adapters.ParsedRequestAdapter;
import cleancoderscom.strategies.SimpleRequestParser;
import cleancoderscom.parser.RequestParser;
import cleancoderscom.router.Router;
import cleancoderscom.summaries.controller.CodecastSummariesController;

public class WebServerConfiguration {

    private final ParsedRequestAdapter adapter;
    private final Router router;
    private final RequestParser parser;

    public WebServerConfiguration() {
        // TODO: the configuration could be read from a fancy Properties file that is pass to Main when is called.
        var factory = new UseCaseFactoryImpl();
        var builder = new RequestBuilderImpl();
        adapter = new ParsedRequestAdapter(builder);
        parser = new SimpleRequestParser();
        router = new Router();
        router.addRoute("summaries", new CodecastSummariesController(factory));
        router.addRoute("details", new CodecastDetailsController(factory));
    }

    public ParsedRequestAdapter getAdapter() {
        return adapter;
    }

    public Router getRouter() {
        return router;
    }

    public RequestParser getParser() {
        return parser;
    }
}
