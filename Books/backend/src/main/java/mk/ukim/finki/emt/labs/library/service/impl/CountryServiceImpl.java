package mk.ukim.finki.emt.labs.library.service.impl;

import mk.ukim.finki.emt.labs.library.model.Country;
import mk.ukim.finki.emt.labs.library.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.labs.library.repository.CountryRepository;
import mk.ukim.finki.emt.labs.library.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public Optional<Country> save(Country country) {
        Country newCountry = new Country(country.getName(), country.getContinent());
        return Optional.of(this.countryRepository.save(newCountry));
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.findById(id).orElseThrow(() -> new CountryNotFoundException(id));

        country.setName(name);
        country.setContinent(continent);

        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, Country country) {
        Country country1 = this.findById(id).orElseThrow(() -> new CountryNotFoundException(id));

        country1.setName(country.getName());
        country1.setContinent(country.getContinent());

        return Optional.of(this.countryRepository.save(country1));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
