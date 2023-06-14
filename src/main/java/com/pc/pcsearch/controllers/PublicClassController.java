package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.Like;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import com.pc.pcsearch.services.PublicLikeService;
import com.pc.pcsearch.services.PublicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user/like")
public class PublicClassController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildPCRepository buildPCRepository;

    @Autowired
    PublicLikeService publicLikeService;
    public User isUserOwnedBuild(Authentication authentication, long id){
        User user = userRepository.findByUsername(authentication.getName()).orElse(null);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                user != null
                        && buildPC != null
                        && user.getId() == buildPC.getUser().getId()

        ) return user;

        return null;
    }

    @PostMapping("/{id}")
    public Like putLike(@PathVariable long id, Authentication auth){
        User user = isUserOwnedBuild(auth, id);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(user != null && buildPC != null) return publicLikeService.putLike(buildPC, user);
        else return null;
    }

    @GetMapping("/{id}")
    public Boolean isLiked(@PathVariable long id, Authentication auth){
        User user = isUserOwnedBuild(auth, id);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(user != null && buildPC != null) return publicLikeService.isLiked(buildPC, user);
        else return false;
    }
}
