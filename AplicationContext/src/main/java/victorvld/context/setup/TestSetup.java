package victorvld.context.setup;

import victorvld.entities.Codecast;
import victorvld.inMemory.InMemoryCodecastGateway;
import victorvld.inMemory.InMemoryUserGateway;
import victorvld.GateKeeper;
import victorvld.context.Context;
import victorvld.entities.License;
import victorvld.entities.User;
import victorvld.inMemory.InMemoryLicenseGateway;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static victorvld.entities.License.LicenseType.VIEWING;

public class TestSetup {

    public static void setupContext() {
        Context.codecastGateway = new InMemoryCodecastGateway();
        Context.userGateway = new InMemoryUserGateway();
        Context.licenseGateway = new InMemoryLicenseGateway();
        Context.gateKeeper = new GateKeeper();
    }

    public static void setupSampleData() {
        setupContext();
        User bob = new User("Bob");
        User Micha = new User("Micha");

        Context.userGateway.save(bob);
        Context.userGateway.save(Micha );

        Codecast e1 = new Codecast();
        e1.setTitle("Episode 1 - The Beginning");
        e1.setPublicationDate(LocalDate.of(2022, 11, 19));
        e1.setPermalink("e1");
        e1.setAuthor("Bob");
        e1.setDuration(Duration.of(100, ChronoUnit.MINUTES));

        Codecast e2 = new Codecast();
        e2.setTitle("Episode 2 - The Continuation");
        e2.setPublicationDate(LocalDate.of(2022, 11, 20));
        e2.setPermalink("e2");
        e2.setAuthor("Cervantes");
        e2.setDuration(Duration.of(200, ChronoUnit.MINUTES));

        Codecast e3 = new Codecast();
        e3.setTitle("Episode 3 - The End");
        e3.setPublicationDate(LocalDate.of(2022, 12, 7));
        e3.setPermalink("e3");
        e3.setAuthor("Delibes");
        e3.setDuration(Duration.of(37, ChronoUnit.MINUTES));

        Context.codecastGateway.save(e1);
        Context.codecastGateway.save(e2);
        Context.codecastGateway.save(e3);

        License bobE1 = new License(VIEWING, bob, e1);
        License bobE2 = new License(VIEWING, bob, e2);
        License bobE3 = new License(VIEWING, bob, e3);

        Context.licenseGateway.save(bobE1);
        Context.licenseGateway.save(bobE2);
        Context.licenseGateway.save(bobE3);

        Context.gateKeeper.setLoggedInUser(bob);
    }

}
