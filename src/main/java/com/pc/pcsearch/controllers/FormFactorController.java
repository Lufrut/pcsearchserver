package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.services.FormFactorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class FormFactorController {
    @Autowired
    FormFactorService formFactorService;

    @PostMapping("/admin/formFactor")
    public FormFactor create(FormFactor formFactor) {
        return formFactorService.create(formFactor);
    }

    @GetMapping("/all/formFactor/{id}")
    public Optional<FormFactor> getOne(@PathVariable long id) {
        return formFactorService.getOne(id);
    }

    @GetMapping("/all/formFactor")
    public List<FormFactor> getAll() {
        return formFactorService.getAll();
    }

    @PutMapping("/admin/formFactor/{id}")
    public FormFactor update(@Valid @RequestBody FormFactor formFactor, @PathVariable long id) {
        return formFactorService.update(formFactor, id);
    }

    @DeleteMapping("/admin/formFactor/{id}")
    public String delete(@PathVariable long id) {
        formFactorService.delete(id);
        return "Successfully deleted";
    }
}
