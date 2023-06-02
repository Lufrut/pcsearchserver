package com.pc.pcsearch.controllers.storage;

import com.pc.pcsearch.models.buildpc.storage.Ssd;
import com.pc.pcsearch.services.storage.SsdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class SsdController {
    @Autowired
    SsdService ssdService;

    @PostMapping("/admin/ssd")
    public Ssd create(@Valid @RequestBody Ssd ssd){
        return ssdService.create(ssd);
    }

    @GetMapping("/all/ssd/{id}")
    public Optional<Ssd> getOne(@PathVariable long id){
        return ssdService.getOne(id);
    }

    @GetMapping("/all/ssd")
    public List<Ssd> getAll(){
        return ssdService.getAll();
    }

    @PutMapping("/admin/ssd/{id}")
    public Ssd update(@Valid @RequestBody Ssd ssd, @PathVariable long id){
        return ssdService.update(ssd, id);
    }

    @DeleteMapping("/admin/ssd/{id}")
    public String delete(@PathVariable long id){
        ssdService.delete(id);
        return "Successful deleted";
    }
}
