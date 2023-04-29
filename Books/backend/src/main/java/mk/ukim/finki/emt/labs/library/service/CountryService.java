package mk.ukim.finki.emt.labs.library.service;


import mk.ukim.finki.emt.labs.library.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> listAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);
    Optional<Country> save(Country country);

    Optional<Country> edit(Long id, String name, String continent);
    Optional<Country> edit(Long id, Country country);

    void deleteById(Long id);

}
