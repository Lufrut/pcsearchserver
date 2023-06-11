package com.pc.pcsearch.controllers.storage;

import com.pc.pcsearch.models.buildpc.storage.SsdCellsType;
import com.pc.pcsearch.services.storage.SsdCellsTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class SsdCellsTypeController {
    @Autowired
    SsdCellsTypeService ssdCellsTypeService;

    @PostMapping("/admin/ssdCellsType")
    public SsdCellsType create(@Valid @RequestBody SsdCellsType ssdCellsType){
        return ssdCellsTypeService.create(ssdCellsType);
    }
    @GetMapping("/all/ssdCellsType/{id}")
    public Optional<SsdCellsType> getOne(@PathVariable long id){
        return ssdCellsTypeService.getOne(id);
    }

    @GetMapping("/all/ssdCellsType")
    public List<SsdCellsType> getAll(){
        return ssdCellsTypeService.getAll();
    }

    @PutMapping("/admin/ssdCellsType/{id}")
    public SsdCellsType update(@Valid @RequestBody SsdCellsType ssdCellsType, @PathVariable long id){
        return ssdCellsTypeService.update(ssdCellsType, id);
    }

    @DeleteMapping("/admin/ssdCellsType/{id}")
    public String delete(@PathVariable long id){
        ssdCellsTypeService.delete(id);
        return "Successful deleted";
    }
}
