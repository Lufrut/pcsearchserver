package com.pc.pcsearch.controllers.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CasePowerSupplyLocation;
import com.pc.pcsearch.services.pccase.CasePowerSupplyLocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CasePowerSupplyLocationController {
    @Autowired
    CasePowerSupplyLocationService service;

    @PostMapping("/admin/casePowerSupplyLocation")
    public CasePowerSupplyLocation create(@RequestBody @Valid CasePowerSupplyLocation location){
        return service.create(location);
    }

    @GetMapping("/all/casePowerSupplyLocation/{id}")
    public Optional<CasePowerSupplyLocation> getOne(@PathVariable long id){
        return service.getOne(id);
    }

    @GetMapping("/all/casePowerSupplyLocation")
    public List<CasePowerSupplyLocation> getAll(){
        return  service.getAll();
    }

    @PutMapping("/admin/casePowerSupplyLocation/{id}")
    public CasePowerSupplyLocation update(
            @RequestBody @Valid CasePowerSupplyLocation location,
            @PathVariable long id
    ){
        return service.update(location, id);
    }

    @DeleteMapping("/admin/casePowerSupplyLocation/{id}")
    public String delete(@PathVariable long id){
        service.delete(id);
        return "Successful deleted";
    }
}
