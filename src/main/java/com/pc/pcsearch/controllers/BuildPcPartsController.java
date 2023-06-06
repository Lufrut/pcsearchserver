package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.models.buildpc.processor.Processor;
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

    @PostMapping("/buildPc")
    public BuildPC create(Authentication auth){
        User user = userRepository.findByUsername(auth.getName()).orElse(null);
        if(user != null) {
            BuildPC buildPC = new BuildPC();
            buildPC.setTotalPrice(0);
            buildPC.setUser(user);
            buildPC.setPcCase(null);
            buildPC.setSsd(null);
            buildPC.setHdd(null);
            buildPC.setPowerSupply(null);
            buildPC.setRam(null);
            buildPC.setProcessor(null);
            buildPC.setCooler(null);
            buildPC.setNameOfBuild(null);
            buildPC.setGraphicCard(null);
            buildPC.setMotherboard(null);
            return buildPCRepository.save(buildPC);
        } else  return  null;
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

    @DeleteMapping("/buildPc/{id}")
    public String delete(@PathVariable long id, Authentication auth){
        if(isUserOwnedRepo(auth, id)){
            service.delete(id);
            return "Successfully deleted";
        } else return null;
    }

    @GetMapping("/buildPc/processor/{id}")
    public List<Processor> getAll(@PathVariable long id, Authentication auth){
        if(isUserOwnedRepo(auth, id)){
            return service.getProcessors(id);
        } else return null;
    }

    @PutMapping("/buildPc/processor/{id}")
    public Processor update(
            @RequestBody @Valid Processor processor,
            @PathVariable long id,
            Authentication auth
    ){
        if(isUserOwnedRepo(auth,id)){
            return service.updateProcessor(processor, id);
        } else return null;
    }

    @DeleteMapping("/buildPc/processor/{id}")
    public void deleteProcessor(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteProcessor(id);
        }
    }
    @GetMapping("/buildPc/motherboard/{id}")
    public List<Motherboard> getMotherboards(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getMotherboards(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/motherboard/{id}")
    public Motherboard updateMotherboard(
            @RequestBody @Valid Motherboard motherboard,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateMotherboard(motherboard, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/motherboard/{id}")
    public void deleteMotherboard(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteMotherboard(id);
        }
    }
}
