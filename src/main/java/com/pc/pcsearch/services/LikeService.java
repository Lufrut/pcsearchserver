package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    Like create(Like like);

    Optional<Like> getOne(long id);

    List<Like> getAll();

    Like update(Like like, long id);

    void delete(long id);
}
