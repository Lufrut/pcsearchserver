package com.pc.pcsearch.controllers.storage;

import com.pc.pcsearch.models.buildpc.storage.Hdd;
import com.pc.pcsearch.services.storage.HddService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class HddController {
    @Autowired
    HddService hddService;

    @PostMapping("/admin/hdd")
    public Hdd create(@Valid @RequestBody Hdd hdd){
        return hddService.create(hdd);
    }

    @GetMapping("/all/hdd/{id}")
    public Optional<Hdd> getOne(@PathVariable long id){
        return hddService.getOne(id);
    }

    @GetMapping("/all/hdd")
    public List<Hdd> getAll(){
        return hddService.getAll();
    }

    @PutMapping("/admin/hdd/{id}")
    public Hdd update(@Valid @RequestBody Hdd hdd, @PathVariable long id){
        return hddService.update(hdd, id);
    }

    @DeleteMapping("/admin/hdd/{id}")
    public String delete(@PathVariable long id){
        hddService.delete(id);
        return "Successful deleted";
    }
}
