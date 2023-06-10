package com.pc.pcsearch.services.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUGeneration;
import com.pc.pcsearch.postgresql.repository.processor.CPUGenerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CPUGenerationServiceImpl implements CPUGenerationService {
    @Autowired
    CPUGenerationRepository cpuGenerationRepository;

    @Override
    public CPUGeneration create(CPUGeneration cpuGeneration) {
        return cpuGenerationRepository.save(cpuGeneration);
    }

    @Override
    public Optional<CPUGeneration> getOne(long id) {
        return cpuGenerationRepository.findById(id);
    }

    @Override
    public List<CPUGeneration> getAll() {
        return cpuGenerationRepository.findAll();
    }

    @Override
    public CPUGeneration update(CPUGeneration cpuGeneration, long id) {
        CPUGeneration temp = cpuGenerationRepository.findById(id).orElse(null);
        if (temp != null) {
            temp = cpuGeneration;
            return cpuGenerationRepository.save(temp);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        cpuGenerationRepository.deleteById(id);
    }
}