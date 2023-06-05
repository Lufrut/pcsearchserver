package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import com.pc.pcsearch.services.BuildPCPartsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user/")
public class BuildPcPartsController {
    @Autowired
    BuildPCPartsService service;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildPCRepository buildPCRepository;

    public boolean isUserOwnedRepo(Authentication authentication, long id){
        User user = userRepository.findByUsername(authentication.getName()).orElse(null);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(user != null && buildPC != null){
            return user.getId() == buildPC.getUser().getId();
        } else return false;
    }

    @GetMapping("/buildPc/{id}")
    public Optional<BuildPC> getOne(@PathVariable long id, Authentication auth){
        if(isUserOwnedRepo(auth, id)){
            return service.getOne(id);
        } else return null;
    }

    @GetMapping("/buildPc")
    public List<BuildPC> getAll(Authentication auth){
        User user = userRepository.findByUsername(auth.getName()).orElse(null);
        if(user != null){
            return service.getAll(user);
        } else return null;
    }

    @PutMapping("/buildPc/{id}")
    public BuildPC update(
            @RequestBody @Valid BuildPC buildPC,
            @PathVariable long id,
            Authentication auth
            ){
        if(isUserOwnedRepo(auth,id)){
            return service.update(buildPC, id);
        } else return null;
    }
}
