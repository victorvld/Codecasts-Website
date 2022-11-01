package cleancoderscom.usecases.codecastDetails;

public interface CodecastDetailsOutputBoundary {
     CodecastDetailsViewModel getViewModel();

     void present(CodecastDetailsResponseModel responseModel);
}
