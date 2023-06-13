package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/admin/user")
    public User createAdmin(@Valid @RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/admin/user/{id}")
    public User update(@Valid @RequestBody User user, @PathVariable long id){
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
