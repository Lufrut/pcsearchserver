package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.Like;
import com.pc.pcsearch.postgresql.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeRepository likeRepository;

    @Override
    public Like create(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Optional<Like> getOne(long id) {
        return likeRepository.findById(id);
    }

    @Override
    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    @Override
    public Like update(Like like, long id) {
        Like temp = likeRepository.findById(id).orElse(null);
        if (temp != null) {
            return likeRepository.save(like);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        likeRepository.deleteById(id);
    }
}
