package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.models.buildpc.pccase.Case;
import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;
import com.pc.pcsearch.models.buildpc.processor.Processor;
import com.pc.pcsearch.models.buildpc.ram.Ram;
import com.pc.pcsearch.models.buildpc.storage.Hdd;
import com.pc.pcsearch.models.buildpc.storage.Ssd;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
import com.pc.pcsearch.postgresql.repository.UserRepository;
import com.pc.pcsearch.services.BuildPCPartsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user/")
public class BuildPcPartsController {
    @Autowired
    BuildPCPartsService service;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildPCRepository buildPCRepository;

    public boolean isUserOwnedRepo(Authentication authentication, long id){
        User user = userRepository.findByUsername(authentication.getName()).orElse(null);
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(user != null && buildPC != null){
            return user.getId() == buildPC.getUser().getId();
        } else return false;
    }

    @PostMapping("/buildPc")
    public BuildPC create(Authentication auth){
        User user = userRepository.findByUsername(auth.getName()).orElse(null);
        if(user != null) {
            BuildPC buildPC = new BuildPC();
            buildPC.setTotalPrice(0);
            buildPC.setUser(user);
            buildPC.setPcCase(null);
            buildPC.setSsd(null);
            buildPC.setHdd(null);
            buildPC.setPowerSupply(null);
            buildPC.setRam(null);
            buildPC.setProcessor(null);
            buildPC.setCooler(null);
            buildPC.setNameOfBuild(null);
            buildPC.setGraphicCard(null);
            buildPC.setMotherboard(null);
            return buildPCRepository.save(buildPC);
        } else  return  null;
    }

    @GetMapping("/buildPc/{id}")
    public Optional<BuildPC> getOne(@PathVariable long id, Authentication auth){
        if(isUserOwnedRepo(auth, id)){
            return service.getOne(id);
        } else return Optional.empty();
    }

    @GetMapping("/buildPc")
    public List<BuildPC> getAll(Authentication auth){
        User user = userRepository.findByUsername(auth.getName()).orElse(null);
        if(user != null){
            return service.getAll(user);
        } else return null;
    }

    @PutMapping("/buildPc/{id}")
    public BuildPC update(
            @RequestBody @Valid BuildPC buildPC,
            @PathVariable long id,
            Authentication auth
            ){
        if(isUserOwnedRepo(auth,id)){
            return service.update(buildPC, id);
        } else return null;
    }

    @DeleteMapping("/buildPc/{id}")
    public String delete(@PathVariable long id, Authentication auth){
        if(isUserOwnedRepo(auth, id)){
            service.delete(id);
            return "Successfully deleted";
        } else return null;
    }

    @GetMapping("/buildPc/processor/{id}")
    public List<Processor> getAll(@PathVariable long id, Authentication auth){
        if(isUserOwnedRepo(auth, id)){
            return service.getProcessors(id);
        } else return null;
    }

    @PutMapping("/buildPc/processor/{id}")
    public Processor update(
            @RequestBody @Valid Processor processor,
            @PathVariable long id,
            Authentication auth
    ){
        if(isUserOwnedRepo(auth,id)){
            return service.updateProcessor(processor, id);
        } else return null;
    }

    @DeleteMapping("/buildPc/processor/{id}")
    public void deleteProcessor(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteProcessor(id);
        }
    }
    @GetMapping("/buildPc/motherboard/{id}")
    public List<Motherboard> getMotherboards(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getMotherboards(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/motherboard/{id}")
    public Motherboard updateMotherboard(
            @RequestBody @Valid Motherboard motherboard,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateMotherboard(motherboard, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/motherboard/{id}")
    public void deleteMotherboard(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteMotherboard(id);
        }
    }

    @GetMapping("/buildPc/cooler/{id}")
    public List<Cooler> getCoolers(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getCoolers(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/cooler/{id}")
    public Cooler updateCooler(
            @RequestBody @Valid Cooler cooler,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateCooler(cooler, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/cooler/{id}")
    public void deleteCooler(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteCooler(id);
        }
    }

    @GetMapping("/buildPc/graphicCard/{id}")
    public List<GraphicCard> getGraphicCards(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getGraphicCards(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/graphicCard/{id}")
    public GraphicCard updateGraphicCard(
            @RequestBody @Valid GraphicCard graphicCard,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateGraphicCard(graphicCard, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/graphicCard/{id}")
    public void deleteGraphicCard(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteGraphicCard(id);
        }
    }

    @GetMapping("/buildPc/ram/{id}")
    public List<Ram> getRams(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getRams(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/ram/{id}")
    public Ram updateRam(
            @RequestBody @Valid Ram ram,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateRam(ram, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/ram/{id}")
    public void deleteRam(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteRam(id);
        }
    }

    @DeleteMapping("/buildPc/ramAll/{id}")
    public void deleteAllRam(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteAllRam(id);
        }
    }

    @GetMapping("/buildPc/hdd/{id}")
    public List<Hdd> getHdds(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getHdds(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/hdd/{id}")
    public Hdd updateHdd(
            @RequestBody @Valid Hdd hdd,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateHdd(hdd, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/hdd/{id}")
    public void deleteHdd(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteHdd(id);
        }
    }

    @DeleteMapping("/buildPc/hddAll/{id}")
    public void deleteAllHdd(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteAllHdd(id);
        }
    }
    @GetMapping("/buildPc/ssd/{id}")
    public List<Ssd> getSsds(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getSsds(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/ssd/{id}")
    public Ssd updateSsd(
            @RequestBody @Valid Ssd ssd,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateSsd(ssd, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/ssd/{id}")
    public void deleteSsd(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteSsd(id);
        }
    }

    @DeleteMapping("/buildPc/ssdAll/{id}")
    public void deleteAllSsd(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteAllSsd(id);
        }
    }

    @GetMapping("/buildPc/powerSupply/{id}")
    public List<PowerSupply> getPowerSupplies(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getPowerSupplies(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/powerSupply/{id}")
    public PowerSupply updatePowerSupply(
            @RequestBody @Valid PowerSupply powerSupply,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updatePowerSupply(powerSupply, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/powerSupply/{id}")
    public void deletePowerSupply(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deletePowerSupply(id);
        }
    }

    @GetMapping("/buildPc/case/{id}")
    public List<Case> getCases(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            return service.getCases(id);
        } else {
            return null;
        }
    }

    @PutMapping("/buildPc/case/{id}")
    public Case updateCase(
            @RequestBody @Valid Case pcCase,
            @PathVariable long id,
            Authentication auth
    ) {
        if (isUserOwnedRepo(auth, id)) {
            return service.updateCase(pcCase, id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/buildPc/case/{id}")
    public void deleteCase(@PathVariable long id, Authentication auth) {
        if (isUserOwnedRepo(auth, id)) {
            service.deleteCase(id);
        }
    }
}
