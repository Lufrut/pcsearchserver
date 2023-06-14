package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.models.buildpc.pccase.PCCase;
import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;
import com.pc.pcsearch.models.buildpc.processor.Processor;
import com.pc.pcsearch.models.buildpc.ram.Ram;
import com.pc.pcsearch.models.buildpc.storage.Hdd;
import com.pc.pcsearch.models.buildpc.storage.Ssd;

import java.util.List;
import java.util.Optional;

public interface BuildPCPartsService {

    List<BuildPC> getAllByRating();

    BuildPC create(BuildPC buildPC);

    Optional<BuildPC> getOne(long id);

    List<BuildPC> getAll(User user);

    BuildPC update(BuildPC buildPC, long id);

    void delete(long id);
    List<Processor> getProcessors(long id);

    Processor updateProcessor(Processor processor, long id);

    void deleteProcessor(long id);

    List<Motherboard> getMotherboards(long id);

    Motherboard updateMotherboard(Motherboard motherboard, long id);

    void deleteMotherboard(long id);

    List<Cooler> getCoolers(long id);

    Cooler updateCooler(Cooler cooler, long id);

    void deleteCooler(long id);

    List<GraphicCard> getGraphicCards(long id);

    GraphicCard updateGraphicCard(GraphicCard graphicCard, long id);

    void deleteGraphicCard(long id);

    List<Ram> getRams(long id);

    Ram updateRam(Ram ram, long id);

    void deleteRam(long id);

    void deleteAllRam(long id);

    List<Hdd> getHdds(long id);

    Hdd updateHdd(Hdd hdd, long id);

    void deleteHdd(long id);

    void deleteAllHdd(long id);

    List<Ssd> getSsds(long id);

    Ssd updateSsd(Ssd ssd, long id);

    void deleteSsd(long id);

    void deleteAllSsd(long id);

    List<PowerSupply> getPowerSupplies(long id);

    PowerSupply updatePowerSupply(PowerSupply powerSupply, long id);

    void deletePowerSupply(long id);

    List<PCCase> getCases(long id);

    PCCase updateCase(PCCase item, long id);

    void deleteCase(long id);
}
