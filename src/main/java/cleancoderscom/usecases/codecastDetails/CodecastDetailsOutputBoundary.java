package cleancoderscom.usecases.codecastDetails;

public interface CodecastDetailsOutputBoundary {
     CodecastDetailsViewModel getViewModel();

     String present(CodecastDetailsResponseModel responseModel);
}
