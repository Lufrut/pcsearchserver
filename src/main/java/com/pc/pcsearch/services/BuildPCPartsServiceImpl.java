package com.pc.pcsearch.services;

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
import com.pc.pcsearch.postgresql.repository.cooler.CoolerRepository;
import com.pc.pcsearch.postgresql.repository.graphiccard.GraphicCardRepository;
import com.pc.pcsearch.postgresql.repository.motherboard.MotherboardRepository;
import com.pc.pcsearch.postgresql.repository.pccase.CaseRepository;
import com.pc.pcsearch.postgresql.repository.powersupply.PowerSupplyRepository;
import com.pc.pcsearch.postgresql.repository.processor.ProcessorRepository;
import com.pc.pcsearch.postgresql.repository.ram.RamRepository;
import com.pc.pcsearch.postgresql.repository.storage.HddRepository;
import com.pc.pcsearch.postgresql.repository.storage.SsdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildPCPartsServiceImpl implements BuildPCPartsService{
    @Autowired
    ProcessorRepository processorRepository;

    @Autowired
    MotherboardRepository motherboardRepository;

    @Autowired
    CoolerRepository coolerRepository;

    @Autowired
    GraphicCardRepository graphicCardRepository;

    @Autowired
    RamRepository ramRepository;

    @Autowired
    HddRepository hddRepository;

    @Autowired
    SsdRepository ssdRepository;

    @Autowired
    PowerSupplyRepository powerSupplyRepository;

    @Autowired
    CaseRepository caseRepository;

    @Autowired
    BuildPCRepository buildPCRepository;

    @Override
    public BuildPC create(BuildPC buildPC) {
        return buildPCRepository.save(buildPC);
    }

    @Override
    public Optional<BuildPC> getOne(long id) {
        return buildPCRepository.findById(id);
    }

    @Override
    public List<BuildPC> getAll(User user) {
        return buildPCRepository.findByUser(user);
    }

    @Override
    public BuildPC update(BuildPC buildPC, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if (temp != null) {
            return buildPCRepository.save(buildPC);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        buildPCRepository.deleteById(id);
    }


    @Override
    public List<Processor> getProcessors(long id) {
        return processorRepository.findAll();
    }

    @Override
    public Processor updateProcessor(Processor processor, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setProcessor(processor);
            buildPCRepository.save(temp);
            return processor;
        } else return null;
    }

    @Override
    public void deleteProcessor(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setProcessor(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<Motherboard> getMotherboards(long id) {
        return motherboardRepository.findAll();
    }

    @Override
    public Motherboard updateMotherboard(Motherboard motherboard, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setMotherboard(motherboard);
            buildPCRepository.save(temp);
            return motherboard;
        } else return null;
    }

    @Override
    public void deleteMotherboard(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setMotherboard(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<Cooler> getCoolers(long id) {
        return coolerRepository.findAll();
    }

    @Override
    public Cooler updateCooler(Cooler cooler, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setCooler(cooler);
            buildPCRepository.save(temp);
            return cooler;
        } else return null;
    }

    @Override
    public void deleteCooler(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setCooler(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<GraphicCard> getGraphicCards(long id) {
        return graphicCardRepository.findAll();
    }

    @Override
    public GraphicCard updateGraphicCard(GraphicCard graphicCard, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setGraphicCard(graphicCard);
            buildPCRepository.save(temp);
            return graphicCard;
        } else return null;
    }

    @Override
    public void deleteGraphicCard(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setGraphicCard(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<Ram> getRams(long id) {
        return ramRepository.findAll();
    }

    @Override
    public Ram updateRam(Ram ram, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            List<Ram> rams = temp.getRam();
            rams.add(ram);
            temp.setRam(rams);
            buildPCRepository.save(temp);
            return ram;
        } else return null;
    }

    @Override
    public void deleteRam(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            List<Ram> rams = temp.getRam();
            if (temp.getRam() != null) {
                rams.remove(0);
                if(rams.isEmpty()) rams = null;
            }
            temp.setRam(rams);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public void deleteAllRam(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setRam(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<Hdd> getHdds(long id) {
        return hddRepository.findAll();
    }

    @Override
    public Hdd updateHdd(Hdd hdd, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            List<Hdd>  hdds = temp.getHdd();
            hdds.add(hdd);
            temp.setHdd(hdds);
            buildPCRepository.save(temp);
            return hdd;
        } else return null;
    }

    @Override
    public void deleteHdd(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            List<Hdd> hdds = temp.getHdd();
            if (temp.getRam() != null) {
                hdds.remove(0);
                if(hdds.isEmpty()) hdds = null;
            }
            temp.setHdd(hdds);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public void deleteAllHdd(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setHdd(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<Ssd> getSsds(long id) {
        return ssdRepository.findAll();
    }

    @Override
    public Ssd updateSsd(Ssd ssd, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            List<Ssd>  ssds = temp.getSsd();
            ssds.add(ssd);
            temp.setSsd(ssds);
            buildPCRepository.save(temp);
            return ssd;
        } else return null;
    }

    @Override
    public void deleteSsd(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            List<Ssd> ssds = temp.getSsd();
            if (temp.getRam() != null) {
                ssds.remove(0);
                if(ssds.isEmpty()) ssds = null;
            }
            temp.setSsd(ssds);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public void deleteAllSsd(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setSsd(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<PowerSupply> getPowerSupplies(long id) {
        return powerSupplyRepository.findAll();
    }

    @Override
    public PowerSupply updatePowerSupply(PowerSupply powerSupply, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setPowerSupply(powerSupply);
            buildPCRepository.save(temp);
            return powerSupply;
        } else return null;
    }

    @Override
    public void deletePowerSupply(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setPowerSupply(null);
            buildPCRepository.save(temp);
        }
    }

    @Override
    public List<Case> getCases(long id) {
        return caseRepository.findAll();
    }

    @Override
    public Case updateCase(Case item, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setPcCase(item);
            buildPCRepository.save(temp);
            return item;
        } else return null;
    }

    @Override
    public void deleteCase(long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            temp.setPcCase(null);
            buildPCRepository.save(temp);
        }
    }
}
