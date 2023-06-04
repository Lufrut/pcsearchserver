package com.pc.pcsearch.controllers.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardChipset;
import com.pc.pcsearch.services.motherboard.MotherboardChipsetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class MotherboardChipsetController {
    @Autowired
    MotherboardChipsetService chipsetService;

    @PostMapping("/admin/motherboardСhipset")
    public MotherboardChipset create(@Valid  @RequestBody MotherboardChipset chipset) {
        return chipsetService.create(chipset);
    }

    @GetMapping("/all/motherboardChipset/{id}")
    public Optional<MotherboardChipset> getOne(@PathVariable long id) {
        return chipsetService.getOne(id);
    }

    @GetMapping("/all/motherboardChipset")
    public List<MotherboardChipset> getAll() {
        return chipsetService.getAll();
    }

    @PutMapping("/admin/motherboardСhipset/{id}")
    public MotherboardChipset update(@Valid @RequestBody MotherboardChipset chipset, @PathVariable long id) {
        return chipsetService.update(chipset, id);
    }

    @DeleteMapping("/admin/motherboardСhipset/{id}")
    public String delete(@PathVariable long id) {
        chipsetService.delete(id);
        return "Successful deleted";
    }
}

