package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardChipset;
import com.pc.pcsearch.postgresql.repository.motherboard.MotherboardChipsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MotherboardChipsetServiceImpl implements MotherboardChipsetService {
    @Autowired
    MotherboardChipsetRepository chipsetRepository;

    @Override
    public MotherboardChipset create(MotherboardChipset chipset) {
        return chipsetRepository.save(chipset);
    }

    @Override
    public Optional<MotherboardChipset> getOne(long id) {
        return chipsetRepository.findById(id);
    }

    @Override
    public List<MotherboardChipset> getAll() {
        return chipsetRepository.findAll();
    }

    @Override
    public MotherboardChipset update(MotherboardChipset chipset, long id) {
        MotherboardChipset temp = chipsetRepository.findById(id).orElse(null);
        if (temp != null) {
            return chipsetRepository.save(chipset);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        chipsetRepository.deleteById(id);
    }
}
