package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import com.pc.pcsearch.services.PublicUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user/user")
public class PublicUserController {
    @Autowired
    PublicUserService publicUserService;

    @Autowired
    UserRepository userRepository;
    public User getUser(Authentication auth){
        if(auth != null){
            return userRepository.findByUsername(auth.getName()).orElse(null);


        }
        return null;
    }
    @GetMapping("")
    public Optional<User> getOne(Authentication auth){
        User temp = getUser(auth);
        if (temp != null) return publicUserService.getOne(temp.getId());
        return Optional.empty();
    }

    @PutMapping("")
    public User update(Authentication auth, @RequestBody @Valid User user){
        User temp = getUser(auth);
            if(temp != null){
                return publicUserService.update(user, temp.getId());
            }
            return null;
    }

    @DeleteMapping("")
    public String delete(Authentication auth){
        User temp = getUser(auth);
        if(temp != null){
            publicUserService.delete(temp.getId());
        }
        return "deleted";
    }
}
