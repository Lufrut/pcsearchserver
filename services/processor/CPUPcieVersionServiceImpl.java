package com.pc.pcsearch.services.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUPcieVersion;
import com.pc.pcsearch.postgresql.repository.processor.CPUPcieVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CPUPcieVersionServiceImpl implements CPUPcieVersionService {
    @Autowired
    CPUPcieVersionRepository cpuPcieVersionRepository;

    @Override
    public CPUPcieVersion create(CPUPcieVersion cpuPcieVersion) {
        return cpuPcieVersionRepository.save(cpuPcieVersion);
    }

    @Override
    public Optional<CPUPcieVersion> getOne(long id) {
        return cpuPcieVersionRepository.findById(id);
    }

    @Override
    public List<CPUPcieVersion> getAll() {
        return cpuPcieVersionRepository.findAll();
    }

    @Override
    public CPUPcieVersion update(CPUPcieVersion cpuPcieVersion, long id) {
        CPUPcieVersion temp = cpuPcieVersionRepository.findById(id).orElse(null);
        if (temp != null) {
            temp = cpuPcieVersion;
            return cpuPcieVersionRepository.save(temp);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        cpuPcieVersionRepository.deleteById(id);
    }
}