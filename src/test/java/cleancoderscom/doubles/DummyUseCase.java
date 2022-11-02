package cleancoderscom.doubles;

import cleancoderscom.usecases.Request;
import cleancoderscom.usecases.UseCase;

public class DummyUseCase implements UseCase {

    @Override
    public String execute(Request request) {
        return "TILT";
    }
}
