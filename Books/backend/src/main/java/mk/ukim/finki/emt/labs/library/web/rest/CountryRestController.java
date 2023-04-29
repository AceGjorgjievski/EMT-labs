package mk.ukim.finki.emt.labs.library.web.rest;


import mk.ukim.finki.emt.labs.library.model.Country;
import mk.ukim.finki.emt.labs.library.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    private List<Country> findAll() {
        return this.countryService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return this.countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> add(@RequestBody Country country) {
        return this.countryService.save(country)
                .map(country1 -> ResponseEntity.ok().body(country1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Country> edit(@PathVariable Long id, @RequestBody Country country) {
        return this.countryService.edit(id, country)
                .map(country1 -> ResponseEntity.ok().body(country1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Country> delete(@PathVariable Long id) {
        this.countryService.deleteById(id);
        if (this.countryService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
