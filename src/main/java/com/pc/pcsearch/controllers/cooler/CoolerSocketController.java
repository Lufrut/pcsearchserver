package com.pc.pcsearch.controllers.cooler;

import com.pc.pcsearch.models.buildpc.cooler.CoolerSocket;
import com.pc.pcsearch.services.cooler.CoolerSocketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class CoolerSocketController {
    @Autowired
    CoolerSocketService coolerSocketService;

    @PutMapping("/admin/coolerSocket")
    public CoolerSocket create(@Valid @RequestBody CoolerSocket socket){
        return  coolerSocketService.create(socket);
    }

    @GetMapping("/all/coolerSocket/{id}")
    public Optional<CoolerSocket> getOne(@PathVariable long id){
        return coolerSocketService.getOne(id);
    }

    @GetMapping("/all/coolerSocket")
    public List<CoolerSocket> getAll(){
        return coolerSocketService.getAll();
    }

    @PutMapping("/admin/coolerSocket/{id}")
    public CoolerSocket update(
            @Valid @RequestBody CoolerSocket socket,
            @PathVariable long id
    ){
        return coolerSocketService.update(socket, id);
    }

    @DeleteMapping("/admin/coolerSocket/{id}")
    public String delete(@PathVariable long id){
        coolerSocketService.delete(id);
        return "Successful deleted";
    }
}
