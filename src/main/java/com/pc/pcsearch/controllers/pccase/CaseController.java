package com.pc.pcsearch.controllers.pccase;

import com.pc.pcsearch.models.buildpc.pccase.PCCase;
import com.pc.pcsearch.services.pccase.CaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CaseController {
    @Autowired
    CaseService caseService;

    @PostMapping("/admin/case")
    public PCCase create(@RequestBody @Valid PCCase item){
        return caseService.create(item);
    }

    @GetMapping("/all/case/{id}")
    public Optional<PCCase> getOne(@PathVariable long id){
        return caseService.getOne(id);
    }

    @GetMapping("/all/case")
    public List<PCCase> getAll(){
        return caseService.getAll();
    }

    @PutMapping("/admin/case/{id}")
    public PCCase update(@RequestBody @Valid PCCase item, @PathVariable long id){
        return caseService.update(item, id);
    }

    @DeleteMapping("/admin/case/{id}")
    public String delete(@PathVariable long id){
        caseService.delete(id);
        return "Successful deleted";
    }
}
