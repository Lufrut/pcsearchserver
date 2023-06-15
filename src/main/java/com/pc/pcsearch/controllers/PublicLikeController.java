package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.Like;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import com.pc.pcsearch.services.PublicLikeService;
import com.pc.pcsearch.services.PublicLikeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user/like")
public class PublicLikeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildPCRepository buildPCRepository;

    @Autowired
    PublicLikeService publicLikeService;

    private static final Logger logger = LoggerFactory.getLogger(PublicLikeController.class);
    public User isUserExist(Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).orElse(null);
        if(user != null) return user;
        return null;
    }

    @PostMapping("/{id}")
    public Like putLike(@PathVariable long id, Authentication auth){
        User user = isUserExist(auth);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(user != null && buildPC != null) return publicLikeService.putLike(buildPC, user);
        return null;
    }

    @GetMapping("/{id}")
    public Boolean isLiked(@PathVariable long id, Authentication auth){
        User user = isUserExist(auth);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(user != null && buildPC != null) return publicLikeService.isLiked(buildPC, user);
        else return false;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id, Authentication auth){
        User user = isUserExist(auth);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(user != null && buildPC != null) publicLikeService.removeLike(buildPC, user);
    }
}
