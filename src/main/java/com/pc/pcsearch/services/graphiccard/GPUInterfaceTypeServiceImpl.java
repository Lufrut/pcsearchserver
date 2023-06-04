package com.pc.pcsearch.services.graphiccard;
import com.pc.pcsearch.models.buildpc.graphiccard.GPUInterfaceType;
import com.pc.pcsearch.postgresql.repository.graphiccard.GPUInterfaceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GPUInterfaceTypeServiceImpl implements GPUInterfaceTypeService {
    @Autowired
    GPUInterfaceTypeRepository interfaceTypeRepository;

    @Override
    public GPUInterfaceType create(GPUInterfaceType interfaceType) {
        return interfaceTypeRepository.save(interfaceType);
    }

    @Override
    public Optional<GPUInterfaceType> getOne(long id) {
        return interfaceTypeRepository.findById(id);
    }

    @Override
    public List<GPUInterfaceType> getAll() {
        return interfaceTypeRepository.findAll();
    }

    @Override
    public GPUInterfaceType update(GPUInterfaceType interfaceType, long id) {
        GPUInterfaceType temp = interfaceTypeRepository.findById(id).orElse(null);
        if (temp != null) {
            return interfaceTypeRepository.save(interfaceType);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        interfaceTypeRepository.deleteById(id);
    }
}