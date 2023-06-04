package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.postgresql.repository.motherboard.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MotherboardServiceImpl implements MotherboardService {
    @Autowired
    MotherboardRepository motherboardRepository;

    @Override
    public Motherboard create(Motherboard motherboard) {
        return motherboardRepository.save(motherboard);
    }

    @Override
    public Optional<Motherboard> getOne(long id) {
        return motherboardRepository.findById(id);
    }

    @Override
    public List<Motherboard> getAll() {
        return motherboardRepository.findAll();
    }

    @Override
    public Motherboard update(Motherboard motherboard, long id) {
        Motherboard temp = motherboardRepository.findById(id).orElse(null);
        if (temp != null) {
            return motherboardRepository.save(motherboard);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        motherboardRepository.deleteById(id);
    }
}
