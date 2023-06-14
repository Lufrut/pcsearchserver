package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.models.buildpc.motherboard.MotherboardSocket;
import com.pc.pcsearch.models.buildpc.pccase.PCCase;
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

import java.util.*;

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
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                && buildPC.getProcessor() != null
        ){
                List<Motherboard> motherboards = motherboardRepository.findAll();
                List<Motherboard> sorted = new ArrayList<>();
                for (Motherboard item :
                        motherboards) {
                    if (
                            item.getSocket().getId() == buildPC.getProcessor().getSocket().getId()
                            && item.getMaxTdpOfProcessors() >= buildPC.getProcessor().getTdp()
                    ){
                        sorted.add(item);
                    }
                }
                return sorted;

        }
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
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                && buildPC.getProcessor() != null
        ){
            List<Cooler> coolers = coolerRepository.findAll();
            List<Cooler> sorted = new ArrayList<>();
            for (Cooler item:
                 coolers) {
                for (MotherboardSocket socket:
                     item.getSocket()) {
                    if(
                            buildPC.getProcessor().getSocket().getId() == socket.getId()
                    ){
                        sorted.add(item);
                    }

                }
            }
            List<Cooler> sorted2 = new ArrayList<>();
            long performanceLevelId =  buildPC.getProcessor().getPerformanceLevel().getId();
            for (Cooler item:
                    sorted) {
                if(
                        item.getPerformanceLevel().getId() == performanceLevelId
                ) {
                    sorted.remove(item);
                    sorted2.add(item);
                }
            }
            sorted2.addAll(sorted);
            return sorted2;
        }
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
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                        && buildPC.getProcessor() != null
        ){
        List<GraphicCard> sorted = graphicCardRepository.findAll();
            List<GraphicCard> sorted2 = new ArrayList<>();
        long performanceLevelId =  buildPC.getProcessor().getPerformanceLevel().getId();
        for (GraphicCard item:
                sorted) {
            if(
                    item.getPerformanceLevel().getId() == performanceLevelId
            ) {
                sorted.remove(item);
                sorted2.add(item);
            }
        }
        sorted2.addAll(sorted);
        return sorted2;
    }
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
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                        && buildPC.getMotherboard() != null
                        && buildPC.getProcessor() != null
        ){
            long memoryTypeId = buildPC.getMotherboard().getRamMemoryType().getId();
            List<Ram> rams = ramRepository.findAll();
            List<Ram> sorted = new ArrayList<>();
            for (Ram item:
                 rams) {
                if(item.getMemoryType().getId() == memoryTypeId){
                    sorted.add(item);
                }
            }

                List<Ram> sorted2 = new ArrayList<>();
                long performanceLevelId =  buildPC.getProcessor().getPerformanceLevel().getId();
                for (Ram item:
                        sorted) {
                    if(
                            item.getPerformanceLevel().getId() == performanceLevelId
                    ) {
                        sorted.remove(item);
                        sorted2.add(item);
                    }
                }
                sorted2.addAll(sorted);
                return sorted2;
            }


        return ramRepository.findAll();
    }

    @Override
    public Ram updateRam(Ram ram, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if(temp!= null){
            int memorySize = 0;
            int usedMemorySlots = 0;
            List<Ram> rams = temp.getRam();

            for (Ram item:
                 rams) {
                memorySize += item.getMemoryCapacity();
                usedMemorySlots++;
            }

            if(
                    memorySize >= temp.getMotherboard().getMaxAmountOfRam()
                    || usedMemorySlots >= temp.getMotherboard().getMemorySlots()

            ) return  null;

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
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                        && buildPC.getProcessor() != null
        ){
            List<Hdd> sorted = hddRepository.findAll();
            List<Hdd> sorted2 = new ArrayList<>();
            long performanceLevelId =  buildPC.getProcessor().getPerformanceLevel().getId();
            for (Hdd item:
                    sorted) {
                if(
                        item.getPerformanceLevel().getId() == performanceLevelId
                ) {
                    sorted.remove(item);
                    sorted2.add(item);
                }
            }
            sorted2.addAll(sorted);
            return sorted2;
        }
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
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                        && buildPC.getProcessor() != null
        ){
            List<Ssd> sorted = ssdRepository.findAll();
            List<Ssd> sorted2 = new ArrayList<>();
            long performanceLevelId =  buildPC.getProcessor().getPerformanceLevel().getId();
            for (Ssd item:
                    sorted) {
                if(
                        item.getPerformanceLevel().getId() == performanceLevelId
                ) {
                    sorted.remove(item);
                    sorted2.add(item);
                }
            }
            sorted2.addAll(sorted);
            return sorted2;
        }
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
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                && buildPC.getProcessor() != null
                && buildPC.getGraphicCard() != null
        ){
          return filterPowerSupplyByPerformanceLevel(
                  filterPowerSupplyByTdp(buildPC),
                  buildPC
          );
        }
        return powerSupplyRepository.findAll();
    }
    private List<PowerSupply> filterPowerSupplyByTdp(BuildPC buildPC){
        int tdp = (int) ((buildPC.getProcessor().getTdp()+ buildPC.getGraphicCard().getTdp())*1.3);
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        List<PowerSupply> sorted = new ArrayList<>();

        for (PowerSupply item:
             powerSupplies) {
            if(item.getPower() >= tdp) sorted.add(item);
        }

        return sorted;
    }

    private List<PowerSupply> filterPowerSupplyByPerformanceLevel(List<PowerSupply> powerSupplies, BuildPC buildPC){
        List<PowerSupply> sorted = new ArrayList<>();
        long performanceLevelId =  buildPC.getProcessor().getPerformanceLevel().getId();
        for (PowerSupply item:
                powerSupplies) {
            if(
                    item.getPerformanceLevel().getId() == performanceLevelId
            ) {
                powerSupplies.remove(item);
                sorted.add(item);
            }
        }
        sorted.addAll(powerSupplies);
        return sorted;
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
    public List<PCCase> getCases(long id) {
        BuildPC buildPC = buildPCRepository.findById(id).orElse(null);
        if(
                buildPC != null
                        && buildPC.getProcessor() != null
                        && buildPC.getMotherboard() != null
                        && buildPC.getGraphicCard() != null
        ){
            return filterCaseByPerformanceLevel(
                    filterCaseByGraphicCardLength(
                        filterCaseByFormFactor(buildPC),
                        buildPC
                    ),
                    buildPC
            );

        }
        return caseRepository.findAll();
    }

    private List<PCCase> filterCaseByFormFactor(BuildPC buildPC){
        List<PCCase> PCCases = caseRepository.findAll();
        List<PCCase> sorted = new ArrayList<>();
        long formFactorId = buildPC.getMotherboard().getFormFactor().getId();
        for (PCCase item:
                PCCases) {
            for (FormFactor item2:
                    item.getFormFactor()) {
                if(item2.getId() == formFactorId) sorted.add(item);
            }
        }
        return sorted;
    }

    private List<PCCase> filterCaseByGraphicCardLength(List<PCCase> PCCases, BuildPC buildPC){
        List<PCCase> sorted = new ArrayList<>();
        for (PCCase item:
                PCCases) {
            if(item.getMaxLengthOfGraphicCard() <= buildPC.getGraphicCard().getLength()) sorted.add(item);
        }
        return sorted;
    }

    private List<PCCase> filterCaseByPerformanceLevel(List<PCCase> PCCases, BuildPC buildPC){
        List<PCCase> sorted = new ArrayList<>();
        long performanceLevelId =  buildPC.getProcessor().getPerformanceLevel().getId();
        for (PCCase item:
                PCCases) {
            if(
                    item.getPerformanceLevel().getId() == performanceLevelId
            ) {
                PCCases.remove(item);
                sorted.add(item);
            }
        }
        sorted.addAll(PCCases);
        return sorted;
    }

    @Override
    public PCCase updateCase(PCCase item, long id) {
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
