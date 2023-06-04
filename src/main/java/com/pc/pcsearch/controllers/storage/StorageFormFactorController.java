package com.pc.pcsearch.controllers.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageFormFactor;
import com.pc.pcsearch.services.storage.StorageFormFactorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class StorageFormFactorController {
    @Autowired
    StorageFormFactorService storageFormFactorService;

    @PostMapping("/admin/storageFormFactor")
    public StorageFormFactor create(@Valid @RequestBody StorageFormFactor storageFormFactor){
        return storageFormFactorService.create(storageFormFactor);
    }

    @GetMapping("/all/storageFormFactor/{id}")
    public Optional<StorageFormFactor> getOne(@PathVariable long id){
        return storageFormFactorService.getOne(id);
    }

    @GetMapping("/all/storageFormFactor")
    public List<StorageFormFactor> getAll(){
        return storageFormFactorService.getAll();
    }

    @PutMapping("/admin/storageFormFactor/{id}")
    public StorageFormFactor update(
        @Valid @RequestBody StorageFormFactor storageFormFactor,
        @PathVariable long id
    ){
        return storageFormFactorService.update(storageFormFactor, id);
    }

    @DeleteMapping("/admin/storageFormFactor/{id}")
    public String delete(@PathVariable long id){
        storageFormFactorService.delete(id);
        return "Successful deleted";
    }
}
