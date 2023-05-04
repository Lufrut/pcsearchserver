package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.build_pc.Admin;
import com.pc.pcsearch.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin){
        return adminService.create(admin);
    }

    @PutMapping("/admin/{id}")
    public Admin update(@Valid @RequestBody Admin admin, @PathVariable long id){
        return adminService.update(admin, id);
    }

    @GetMapping("/admin")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @GetMapping("/admin/{id}")
    public Optional<Admin> getOne(@PathVariable long id){
        return adminService.findById(id);
    }

    @DeleteMapping("/admin/{id}")
    void delete(@PathVariable long id){
        adminService.delete(id);
    }

}
