package com.pc.pcsearch.services.ram;

import com.pc.pcsearch.models.buildpc.ram.RamMemoryType;
import com.pc.pcsearch.postgresql.repository.ram.RamMemoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamMemoryTypeServiceImpl implements  RamMemoryTypeService{
    @Autowired
    RamMemoryTypeRepository ramMemoryTypeRepository;

    @Override
    public RamMemoryType create(RamMemoryType ramMemoryType) {
        return ramMemoryTypeRepository.save(ramMemoryType);
    }

    @Override
    public RamMemoryType findById(long id) {
        return ramMemoryTypeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<RamMemoryType> findAll() {
        return ramMemoryTypeRepository.findAll();
    }

    @Override
    public RamMemoryType update(RamMemoryType ramMemoryType, long id) {
        RamMemoryType temp = ramMemoryTypeRepository.findById(id).orElseThrow();
        temp.setMemoryType(ramMemoryType.getMemoryType());
        return ramMemoryTypeRepository.save(temp);
    }

    @Override
    public void delete(long id) {
        ramMemoryTypeRepository.deleteById(id);
    }
}
