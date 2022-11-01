package cleancoderscom.usecases.codecastDetails;

import cleancoderscom.entities.License;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class CodecastDetailsResponseModel {
    public String permalink;
    public String title;
    public String author;
    public LocalDate publicationDate;
    public Duration duration;
    public List<License.LicenseType> licenseTypes;
}
