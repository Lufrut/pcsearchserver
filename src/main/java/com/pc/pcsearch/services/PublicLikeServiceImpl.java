package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.Like;
import com.pc.pcsearch.models.buildpc.Rating;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
import com.pc.pcsearch.postgresql.repository.LikeRepository;
import com.pc.pcsearch.postgresql.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

@Service
public class PublicLikeServiceImpl implements PublicLikeService{
    @Autowired
    LikeRepository likeRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    BuildPCRepository buildPCRepository;

    private static final Logger logger = LoggerFactory.getLogger(PublicLikeServiceImpl.class);
    @Override
    public boolean isLiked(BuildPC buildPC, User user) {
        return !likeRepository.findLikeByBuildPcAndUser(buildPC, user).isEmpty();
    }

    @Override
    public Like putLike(BuildPC buildPC, User user) {
        Rating rating = ratingRepository.findById(buildPC.getRatingId().getId()).orElse(null);
       if(!isLiked(buildPC, user) && rating != null) {
            Like like = new Like();
            like.setUser(user);
            like.setBuildPc(buildPC);
            likeRepository.saveAndFlush(like);
            List<Like> likes = rating.getLike();
            likes.add(like);
            rating.setLike(likes);
            ratingRepository.saveAndFlush(rating);
            buildPC.setCountOfLikes(buildPC.getCountOfLikes() + 1);
            buildPCRepository.saveAndFlush(buildPC);
            return like;
        } else return null;
    }

    @Override
    public void removeLike(BuildPC buildPC, User user) {
        if(isLiked(buildPC, user)) {
            likeRepository.deleteLikeByBuildPcAndUser(buildPC, user);
            buildPC.setCountOfLikes(buildPC.getCountOfLikes() - 1);
            buildPCRepository.save(buildPC);
        }
    }
}
