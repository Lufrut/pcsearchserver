package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.Ram;
import com.pc.pcsearch.postgresql.repository.ram.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RamServiceImpl implements RamService{
    @Autowired
    RamRepository ramRepository;

    @Override
    public Ram create(Ram ram) {
        return ramRepository.save(ram);
    }

    @Override
    public Optional<Ram> findById(long id) {
        return ramRepository.findById(id);
    }

    @Override
    public List<Ram> findAll() {
        return ramRepository.findAll();
    }

    @Override
    public Ram update(Ram ram, long id) {
        Ram temp = ramRepository.findById(id).orElseThrow();

        temp.setName(ram.getName());
        temp.setDescription(ram.getDescription());
        temp.setFrequency(ram.getFrequency());
        temp.setMemoryCapacity(ram.getMemoryCapacity());
        temp.setPerformanceLevel(ram.getPerformanceLevel());
        temp.setMemoryType(ram.getMemoryType());
        temp.setPowerSupplyVoltage(ram.getPowerSupplyVoltage());
        temp.setTimings(ram.getTimings());
        temp.setProducer(ram.getProducer());
        temp.setRecommendedPrice(ram.getRecommendedPrice());

        return ramRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        ramRepository.deleteById(id);
    }
}
