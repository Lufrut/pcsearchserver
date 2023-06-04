package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUTechnologies;
import com.pc.pcsearch.postgresql.repository.graphiccard.GPUTechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GPUTechnologiesServiceImpl implements GPUTechnologiesService {
    @Autowired
    GPUTechnologiesRepository technologiesRepository;

    @Override
    public GPUTechnologies create(GPUTechnologies technologies) {
        return technologiesRepository.save(technologies);
    }

    @Override
    public Optional<GPUTechnologies> getOne(long id) {
        return technologiesRepository.findById(id);
    }

    @Override
    public List<GPUTechnologies> getAll() {
        return technologiesRepository.findAll();
    }

    @Override
    public GPUTechnologies update(GPUTechnologies technologies, long id) {
        GPUTechnologies temp = technologiesRepository.findById(id).orElse(null);
        if (temp != null) {
            return technologiesRepository.save(technologies);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        technologiesRepository.deleteById(id);
    }
}
