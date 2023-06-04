package com.pc.pcsearch.services.processor;


import com.pc.pcsearch.models.buildpc.processor.CPUTech;
import com.pc.pcsearch.postgresql.repository.processor.CPUTechRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CPUTechServiceImpl implements CPUTechService {
    @Autowired
    CPUTechRepository cpuTechRepository;

    @Override
    public CPUTech create(CPUTech cpuTech) {
        return cpuTechRepository.save(cpuTech);
    }

    @Override
    public Optional<CPUTech> getOne(long id) {
        return cpuTechRepository.findById(id);
    }

    @Override
    public List<CPUTech> getAll() {
        return cpuTechRepository.findAll();
    }

    @Override
    public CPUTech update(CPUTech cpuTech, long id) {
        CPUTech temp = cpuTechRepository.findById(id).orElse(null);
        if (temp != null) {
           temp = cpuTech;
            return cpuTechRepository.save(temp);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        cpuTechRepository.deleteById(id);
    }
}
