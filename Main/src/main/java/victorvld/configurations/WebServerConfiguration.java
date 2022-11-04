package victorvld.configurations;

import victorvld.strategies.SimpleRequestParser;
import victorvld.builders.RequestBuilderImpl;
import victorvld.factories.UseCaseFactoryImpl;
import victorvld.details.controller.CodecastDetailsController;
import victorvld.adapters.ParsedRequestAdapter;
import victorvld.parser.RequestParser;
import victorvld.router.Router;
import victorvld.controller.CodecastSummariesController;

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
