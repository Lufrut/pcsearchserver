package com.pc.pcsearch.controllers.ram;

import com.pc.pcsearch.models.buildpc.ram.Ram;
import com.pc.pcsearch.services.ram.RamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RamController {
    @Autowired
    RamService ramService;

    @PostMapping("/admin/ram")
    public Ram ramCreate(@Valid @RequestBody Ram ram){
        return ramService.create(ram);
    }

    @GetMapping("/all/ram/{id}")
    public Optional<Ram> getRam(@PathVariable long id){
        return ramService.findById(id);
    }

    @GetMapping("/all/ram")
    public List<Ram> getAllRam(){
        return ramService.findAll();
    }

    @PutMapping("/admin/ram/{id}")
    public Ram updateRam(@Valid @RequestBody Ram ram, @PathVariable long id){
        return ramService.update(ram, id);
    }

    @DeleteMapping("/admin/ram/{id}")
    public String deleteRam(@PathVariable long id){
        ramService.delete(id);
        return "Successful deleted";
    }

}
