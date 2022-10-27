package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.*;
import cleancoderscom.entities.Codecast;
import cleancoderscom.entities.User;
import cleancoderscom.TestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CodecastDetailsUsecaseTest {


    private User user;

    @BeforeEach
    public void setUp() {
        TestSetup.setupContext();
        user = Context.userGateway.save(new User("User"));
    }

    // Keep separated db IDs and permalinks, they are different things.
    // TODO 27.10.2022. Get this passing.
//    @Test
//    void createCodecastDetailsPresentation() {
//        Codecast codecast = new Codecast();
//        codecast.setTitle("Codecast");
//        codecast.setPermalink("permalink-a");
//        codecast.setPublicationDate(LocalDate.of(2022, 2, 1));
//        Context.codecastGateway.save(codecast);
//        CodecastDetailsUseCase useCase = new CodecastDetailsUseCase();
//        PresentableCodecastDetails details = useCase.requestCodecastDetails(user, "permalink-a");
//
//        Assertions.assertEquals("Codecast", details.title);
//        Assertions.assertEquals("01.02.2022", details.publicationDate);
//    }

    @Test
    void doesntCrashOnMissingCodecast() {
        CodecastDetailsUseCase useCase = new CodecastDetailsUseCase();
        PresentableCodecastDetails details = useCase.requestCodecastDetails(user, "permalink-a");

        Assertions.assertEquals(false, details.wasFound);
    }
}