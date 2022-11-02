package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.entities.User;

public interface CodecastDetailsInputBoundary {
    void detailCodecasts(DetailsRequest request, CodecastDetailsOutputBoundary presenter);
}
