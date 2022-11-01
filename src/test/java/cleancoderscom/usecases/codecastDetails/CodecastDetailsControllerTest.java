package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.Context;
import cleancoderscom.TestSetup;
import cleancoderscom.entities.User;
import cleancoderscom.http.ParsedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CodecastDetailsControllerTest {

    private CodecastDetailsInputBoundarySpy useCaseSpy;
    private CodecastDetailsOutputBoundarySpy presenterSpy;
    private CodecastDetailsViewSpy viewSpy;
    private CodecastDetailsController controller;

    // Our goal is to check the request model is created properly and pass through the boundary.
    @BeforeEach
    void setUp() {
        TestSetup.setupSampleData();
        useCaseSpy = new CodecastDetailsInputBoundarySpy();
        presenterSpy = new CodecastDetailsOutputBoundarySpy();
        viewSpy = new CodecastDetailsViewSpy();
        controller = new CodecastDetailsController(useCaseSpy, presenterSpy, viewSpy);
    }

    @Test
    void testInputBoundaryInvocation() {
        ParsedRequest request = new ParsedRequest("GET", "/episode/e1/show");
        Context.gateKeeper.setLoggedInUser(new User("Bob"));
        controller.handle(request);

        Assertions.assertTrue(useCaseSpy.detailCodecastWasCalled);
        Assertions.assertEquals("Bob", useCaseSpy.request.userName);
        Assertions.assertEquals("/episode/e1/show", useCaseSpy.request.permalink);
        Assertions.assertSame(presenterSpy, useCaseSpy.outputBoundary);
    }

    @Test
    void controllerSendTheViewModelToTheView() {
        setUp();
        presenterSpy.viewModel = new CodecastDetailsViewModel();

        ParsedRequest request = new ParsedRequest("GET", "blah");
        controller.handle(request);

        Assertions.assertTrue(viewSpy.generateViewWasCalled);
        Assertions.assertSame(presenterSpy.viewModel, viewSpy.viewModel);
    }

}