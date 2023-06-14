package com.pc.pcsearch.postgresql.repository;


import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildPCRepository extends JpaRepository<BuildPC, Long> {
    List<BuildPC> findByUser(User user);

    List<BuildPC> findAllByOrderByCountOfLikesDesc();
}