package com.pc.pcsearch.controllers.ram;

import com.pc.pcsearch.models.buildpc.ram.RamMemoryType;
import com.pc.pcsearch.services.ram.RamMemoryTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/")
@RestController
public class RamMemoryTypeController {
    @Autowired
    RamMemoryTypeService ramMemoryTypeService;

    @PostMapping("/admin/ramMemoryType")
    public RamMemoryType createRamMemoryType(@Valid @RequestBody RamMemoryType ramMemoryType){
        return  ramMemoryTypeService.create(ramMemoryType);
    }

    @GetMapping("/all/ramMemoryType/{id}")
    public Optional<RamMemoryType> getRamMemoryType(@PathVariable long id){
        return ramMemoryTypeService.findById(id);
    }

    @GetMapping("/all/ramMemoryType")
    public List<RamMemoryType> getAllRamMemoryType(){
        return ramMemoryTypeService.findAll();
    }

    @PutMapping("/admin/ramMemoryType/{id}")
    public RamMemoryType updateRamMemoryType(
            @Valid @RequestBody RamMemoryType ramMemoryType,
            @PathVariable long id){
        return ramMemoryTypeService.update(ramMemoryType, id);
    }

    @DeleteMapping("/admin/ramMemoryType/{id}")
    public String deleteRamMemoryType(@PathVariable long id){
        ramMemoryTypeService.delete(id);
        return "Successful deleted";
    }
}
