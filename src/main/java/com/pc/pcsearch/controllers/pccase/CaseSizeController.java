package com.pc.pcsearch.controllers.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CaseSize;
import com.pc.pcsearch.services.pccase.CaseSizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CaseSizeController {
    @Autowired
    CaseSizeService service;

    @PostMapping("/admin/caseSize")
    public CaseSize create(@RequestBody @Valid CaseSize caseSize){
        return service.create(caseSize);
    }

    @GetMapping("/all/caseSize/{id}")
    public Optional<CaseSize> getOne(@PathVariable long id){
        return service.getOne(id);
    }

    @GetMapping("/all/caseSize")
    public List<CaseSize> getAll(){
        return service.getAll();
    }

    @PutMapping("/admin/caseSize/{id}")
    public CaseSize update(@RequestBody @Valid CaseSize caseSize, @PathVariable long id){
        return service.update(caseSize, id);
    }

    @DeleteMapping("/admin/caseSize/{id}")
    public String delete(@PathVariable long id){
        service.delete(id);
        return "Successful deleted";
    }
}
