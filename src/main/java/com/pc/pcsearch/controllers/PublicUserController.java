package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import com.pc.pcsearch.services.PublicUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user/user")
public class PublicUserController {

    @Autowired
    PasswordEncoder encoder;

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
    @PostMapping("/pass")
    public String changePassword(@RequestBody String oldPass, @RequestBody String newPass, Authentication auth){
        User temp = getUser(auth);
        if (temp != null ){
            if(temp.getPassword().equals(encoder.encode(oldPass))){
                temp.setPassword(encoder.encode(newPass));
                userRepository.save(temp);
                return "Password successfully changed";
            } else return  "Password not match";
        } else  return "User not exist";
    }
    @GetMapping("")
    public Optional<User> getOne(Authentication auth){
        User temp = getUser(auth);
        if (temp != null) return publicUserService.getOne(temp.getId());
        return Optional.empty();
    }

    @PutMapping("")
    public User update(Authentication auth, @RequestBody User user){
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
