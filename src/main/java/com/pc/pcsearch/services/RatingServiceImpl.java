package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.Rating;
import com.pc.pcsearch.postgresql.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Optional<Rating> getOne(long id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating update(Rating rating, long id) {
        Rating temp = ratingRepository.findById(id).orElse(null);
        if (temp != null) {
            return ratingRepository.save(rating);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        ratingRepository.deleteById(id);
    }
}
