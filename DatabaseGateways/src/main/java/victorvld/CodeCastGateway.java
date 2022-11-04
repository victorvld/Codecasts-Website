package victorvld;

import victorvld.entities.Codecast;

import java.util.List;

public interface CodeCastGateway {
    List<Codecast> findAllCodecastSortedChronologically();

    void delete(Codecast codecast);

    Codecast save(Codecast codecast);

    Codecast findCodecastByTitle(String codecastTitle);

    Codecast findCodecastByPermalink(String permalink);
}
