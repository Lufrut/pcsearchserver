package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamTimings;
import com.pc.pcsearch.postgresql.repository.ram.RamTimingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RamTimingsServiceImpl implements RamTimingsService{
    @Autowired
    RamTimingsRepository ramTimingsRepository;

    @Override
    public RamTimings create(RamTimings ramTimings) {
        return ramTimingsRepository.save(ramTimings);
    }

    @Override
    public Optional<RamTimings> findById(long id) {
        return ramTimingsRepository.findById(id);
    }

    @Override
    public List<RamTimings> findAll() {
        return ramTimingsRepository.findAll();
    }

    @Override
    public RamTimings update(RamTimings ramTimings, long id) {
        RamTimings temp = ramTimingsRepository.findById(id).orElseThrow();
        temp.setTimings(ramTimings.getTimings());
        return ramTimingsRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        ramTimingsRepository.deleteById(id);
    }
}
