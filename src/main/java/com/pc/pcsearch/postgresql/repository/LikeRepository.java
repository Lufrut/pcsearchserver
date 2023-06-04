package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
