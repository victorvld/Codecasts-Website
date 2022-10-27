package cleancoderscom.usecases.codecastSummaries;

import cleancoderscom.Context;
import cleancoderscom.TestSetup;
import cleancoderscom.http.ParsedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CodecastSummariesControllerTest {

    private CodecastSummariesInputBoundarySpy useCaseSpy;
    private CodecastSummariesOutputBoundarySpy presenterSpy;
    private CodecastSummariesViewSpy viewSpy;
    private CodecastSummariesController controller;

    // Our goal is to check the request model is created properly and pass through the boundary.
    @BeforeEach
    void setUp() {
        TestSetup.setupSampleData();
        useCaseSpy = new CodecastSummariesInputBoundarySpy();
        presenterSpy = new CodecastSummariesOutputBoundarySpy();
        viewSpy = new CodecastSummariesViewSpy();
        controller = new CodecastSummariesController(useCaseSpy, presenterSpy, viewSpy);
    }

    @Test
    void testInputBoundaryInvocation() {
        ParsedRequest request = new ParsedRequest("GET", "blah");

        controller.handle(request);

        Assertions.assertTrue(useCaseSpy.summarizeCodecastWasCalled);
        Assertions.assertTrue(Context.userGateway.findUser("Bob").isSame(useCaseSpy.requestedUser));
        Assertions.assertSame(presenterSpy, useCaseSpy.outputBoundary);

        //The controller should use a factory to create the use case.
        // The controller is gonna get control from the webserver first, from a router.
        // We invoke the controller there, and then the controller need to create the use case.

        //List<PresentableCodecastSummaries> summaries = new ArrayList<>();
    }

    @Test
    void controllerSendTheViewModelToTheView() {
        setUp();
        presenterSpy.viewModel = new CodecastSummariesViewModel();

        ParsedRequest request = new ParsedRequest("GET", "blah");
        controller.handle(request);

        Assertions.assertTrue(viewSpy.generateViewWasCalled);
        Assertions.assertSame(presenterSpy.viewModel, viewSpy.viewModel);
    }


}