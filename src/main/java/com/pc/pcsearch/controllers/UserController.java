package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.payload.request.ChangePasswordRequest;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import com.pc.pcsearch.services.PublicUserService;
import com.pc.pcsearch.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @PostMapping("/admin/user/pass/{id}")
    public String changePassword(@PathVariable long id, @RequestBody String password){
        User temp = userRepository.findById(id).orElse(null);
        if (temp != null ){
                temp.setPassword(encoder.encode(password));
                userRepository.save(temp);
                return "Password successfully changed";
        } else  return "User not exist";
    }
    @PostMapping("/admin/user")
    public User createAdmin(@Valid @RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/admin/user/{id}")
    public User update(@RequestBody User user, @PathVariable long id){
        return userService.update(user, id);
    }

    @GetMapping("/all/user")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/all/user/{id}")
    public Optional<User> getOne(@PathVariable long id){
        return userService.findById(id);
    }

    @DeleteMapping("/admin/user/{id}")
    public String delete(@PathVariable long id){
        userService.delete(id);
        return "Successful deleted";
    }
}
