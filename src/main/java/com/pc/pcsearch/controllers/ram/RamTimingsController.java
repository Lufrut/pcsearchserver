package com.pc.pcsearch.controllers.ram;

import com.pc.pcsearch.models.buildpc.ram.RamTimings;
import com.pc.pcsearch.services.ram.RamTimingsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RamTimingsController {
    @Autowired
    RamTimingsService ramTimingsService;

    @PostMapping("/admin/ramTimings")
    public RamTimings createRamTimings(@Valid @RequestBody RamTimings ramTimings){
        return ramTimingsService.create(ramTimings);
    }

    @GetMapping("/all/ramTimings/{id}")
    public Optional<RamTimings> getRamTimings(@PathVariable long id){
        return ramTimingsService.findById(id);
    }

    @GetMapping("/all/ramTimings")
    public List<RamTimings> getAllRamTimings(){
        return ramTimingsService.findAll();
    }

    @PutMapping("/admin/ramTimings/{id}")
    public RamTimings updateRamTimings(
            @Valid @RequestBody RamTimings ramTimings,
            @PathVariable long id
            ){
        return ramTimingsService.update(ramTimings, id);
    }

    @DeleteMapping("/admin/ramTimings/{id}")
    public String deleteRamTimings(@PathVariable long id){
        ramTimingsService.delete(id);
        return "Successful deleted";
    }
}
