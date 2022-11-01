package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.entities.User;

public interface CodecastDetailsInputBoundary {
    void detailCodecasts(CodecastDetailsRequest request, CodecastDetailsOutputBoundary presenter);
}
