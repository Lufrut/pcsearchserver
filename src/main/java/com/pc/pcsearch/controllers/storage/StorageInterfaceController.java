package com.pc.pcsearch.controllers.storage;

import com.pc.pcsearch.models.buildpc.storage.StorageInterface;
import com.pc.pcsearch.services.storage.StorageInterfaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class StorageInterfaceController {
    @Autowired
    StorageInterfaceService storageInterfaceService;

    @PostMapping("/admin/storageInterface")
    public StorageInterface create(@RequestBody @Valid StorageInterface storageInterface){
        return storageInterfaceService.create(storageInterface);
    }

    @GetMapping("/all/storageInterface/{id}")
    public Optional<StorageInterface> getOne(@PathVariable long id){
        return storageInterfaceService.getOne(id);
    }

    @GetMapping("/all/storageInterface")
    public List<StorageInterface> getAll(){
        return storageInterfaceService.getAll();
    }

    @PutMapping("/admin/storageInterface/{id}")
    public StorageInterface update(
        @Valid @RequestBody StorageInterface storageInterface,
        @PathVariable long id
    ){
        return storageInterfaceService.update(storageInterface, id);
    }

    @DeleteMapping("/admin/storageInterface/{id}")
    public String delete(@PathVariable long id){
        storageInterfaceService.delete(id);
        return "Successful deleted";
    }
}
