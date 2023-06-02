package com.pc.pcsearch.controllers.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CaseDesignFeatures;
import com.pc.pcsearch.services.pccase.CaseDesignFeaturesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class CaseDesignFeaturesController {
    @Autowired
    CaseDesignFeaturesService service;

    @PostMapping("/admin/caseDesignFeatures")
    public CaseDesignFeatures create(CaseDesignFeatures features){
        return service.create(features);
    }

    @GetMapping("/all/caseDesignFeatures/{id}")
    public Optional<CaseDesignFeatures> getOne(@PathVariable long id){
        return service.getOne(id);
    }

    @GetMapping("/all/caseDesignFeatures")
    public List<CaseDesignFeatures> getAll(){
        return service.getAll();
    }

    @PutMapping("/admin/caseDesignFeatures/{id}")
    public CaseDesignFeatures update(
            @RequestBody @Valid CaseDesignFeatures features,
            @PathVariable long id
    ){
        return service.update(features, id);
    }

    @DeleteMapping("/admin/caseDesignFeatures/{id}")
    public String  delete(@PathVariable long id){
        service.delete(id);
        return "Successful deleted";
    }
}
