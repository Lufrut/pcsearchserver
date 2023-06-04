package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUMemoryType;
import com.pc.pcsearch.postgresql.repository.graphiccard.GPUMemoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GPUMemoryTypeServiceImpl implements GPUMemoryTypeService {
    @Autowired
    GPUMemoryTypeRepository memoryTypeRepository;

    @Override
    public GPUMemoryType create(GPUMemoryType memoryType) {
        return memoryTypeRepository.save(memoryType);
    }

    @Override
    public Optional<GPUMemoryType> getOne(long id) {
        return memoryTypeRepository.findById(id);
    }

    @Override
    public List<GPUMemoryType> getAll() {
        return memoryTypeRepository.findAll();
    }

    @Override
    public GPUMemoryType update(GPUMemoryType memoryType, long id) {
        GPUMemoryType temp = memoryTypeRepository.findById(id).orElse(null);
        if (temp != null) {
            return memoryTypeRepository.save(memoryType);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        memoryTypeRepository.deleteById(id);
    }
}
