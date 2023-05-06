package com.pc.pcsearch.services.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;
import com.pc.pcsearch.postgresql.repository.powersupply.PowerSupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSupplyServiceImpl implements PowerSupplyService{
    @Autowired
    PowerSupplyRepository powerSupplyRepository;

    @Override
    public PowerSupply create(PowerSupply powerSupply) {
        return powerSupplyRepository.save(powerSupply);
    }

    @Override
    public PowerSupply getOne(long id) {
        return powerSupplyRepository.findById(id).orElseThrow();
    }

    @Override
    public List<PowerSupply> getAll() {
        return powerSupplyRepository.findAll();
    }

    @Override
    public PowerSupply update(PowerSupply powerSupply, long id) {
        PowerSupply temp = powerSupplyRepository.findById(id).orElseThrow();

        temp.setProducer(powerSupply.getProducer());
        temp.setName(powerSupply.getName());
        temp.setPower(powerSupply.getPower());
        temp.setFormFactor(powerSupply.getFormFactor());
        temp.setPerformanceLevel(powerSupply.getPerformanceLevel());
        temp.setPfcModule(powerSupply.isPfcModule());
        temp.setModularConnection(powerSupply.isModularConnection());
        temp.setProtection(powerSupply.getProtection());
        temp.setCpu_4pin(powerSupply.getCpu_4pin());
        temp.setCpu_4plus4pin(powerSupply.getCpu_4plus4pin());
        temp.setPcie_6plus2pin(powerSupply.getPcie_6plus2pin());
        temp.setPcie_8pin(powerSupply.getPcie_8pin());
        temp.setPcie_5_16pin(powerSupply.getPcie_5_16pin());
        temp.setSata(powerSupply.getSata());
        temp.setCount_of_12_v_lines(powerSupply.getCount_of_12_v_lines());
        temp.setDescription(powerSupply.getDescription());
        temp.setRecommendedPrice(powerSupply.getRecommendedPrice());

        return powerSupplyRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        powerSupplyRepository.deleteById(id);
    }
}
