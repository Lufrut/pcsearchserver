package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    Rating create(Rating rating);

    Optional<Rating> getOne(long id);

    List<Rating> getAll();

    Rating update(Rating rating, long id);

    void delete(long id);
}