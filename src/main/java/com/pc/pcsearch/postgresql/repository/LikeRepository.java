package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.Like;
import com.pc.pcsearch.models.buildpc.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findLikeByBuildPcAndUser(BuildPC buildPC, User user);

    void deleteLikeByBuildPcAndUser(BuildPC buildPC, User user);
}
