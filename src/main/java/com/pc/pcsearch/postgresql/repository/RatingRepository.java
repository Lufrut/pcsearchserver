package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
