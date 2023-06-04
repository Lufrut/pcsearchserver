package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.Rating;
import com.pc.pcsearch.services.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping("/admin/rating")
    public Rating create(@Valid @RequestBody Rating rating) {
        return ratingService.create(rating);
    }

    @GetMapping("/all/rating/{id}")
    public Optional<Rating> getOne(@PathVariable long id) {
        return ratingService.getOne(id);
    }

    @GetMapping("/all/rating")
    public List<Rating> getAll() {
        return ratingService.getAll();
    }

    @PutMapping("/admin/rating/{id}")
    public Rating update(@Valid @RequestBody Rating rating, @PathVariable long id) {
        return ratingService.update(rating, id);
    }

    @DeleteMapping("/admin/rating/{id}")
    public String delete(@PathVariable long id) {
        ratingService.delete(id);
        return "Successfully deleted";
    }
}

