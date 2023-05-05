package com.pc.pcsearch.controllers.ram;

import com.pc.pcsearch.models.buildpc.ram.RamProducer;
import com.pc.pcsearch.services.ram.RamProducerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RamProducerController {
    @Autowired
    RamProducerService ramProducerService;

    @PostMapping("/ramProducer")
    public RamProducer createRamProducer(@Valid @RequestBody RamProducer ramProducer){
        return ramProducerService.create(ramProducer);
    }

    @GetMapping("/ramProducer/{id}")
    public RamProducer getRamProducer(@PathVariable long id){
        return ramProducerService.findById(id);
    }

    @GetMapping("/ramProducer")
    public List<RamProducer> getAllRamProducer(){
        return  ramProducerService.findAll();
    }

    @PutMapping("/ramProducer/{id}")
    public RamProducer updateRamProducer(
            @Valid @RequestBody RamProducer ramProducer,
            @PathVariable long id ){
        return ramProducerService.update(ramProducer, id);
    }

    @DeleteMapping("/ramProducer/{id}")
    public String deleteRamProducer(@PathVariable long id ){
        ramProducerService.delete(id);
        return "Successful deleted";
    }
}
