package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.TestSetup;
import cleancoderscom.doubles.RequestBuilderSpy;
import cleancoderscom.doubles.UseCaseFactorySpy;
import cleancoderscom.http.ParsedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CodecastDetailsControllerTest {
    private CodecastDetailsController controller;
    private RequestBuilderSpy builder;
    private UseCaseFactorySpy factory;

    // Our goal is to check the request model is created properly and pass through the boundary.
    @BeforeEach
    void setUp() {
        TestSetup.setupSampleData();
        builder = new RequestBuilderSpy();
        factory = new UseCaseFactorySpy();
        controller = new CodecastDetailsController(factory, builder);
    }

    @Test
    void testInputBoundaryInvocation() {
        ParsedRequest request = new ParsedRequest("GET", "blah");

        controller.handle(request);

        Assertions.assertTrue(builder.buildWasCalled);
        Assertions.assertTrue(factory.makeWasCalled);
    }

}