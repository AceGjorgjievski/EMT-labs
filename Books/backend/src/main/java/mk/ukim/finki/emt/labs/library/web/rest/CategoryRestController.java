package mk.ukim.finki.emt.labs.library.web.rest;


import mk.ukim.finki.emt.labs.library.model.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {


    @GetMapping
    public List<Category> findAll() {
        return Arrays.stream(Category.values()).toList();
    }
}
