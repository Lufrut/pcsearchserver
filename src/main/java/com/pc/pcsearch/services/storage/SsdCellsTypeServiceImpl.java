package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.SsdCellsType;
import com.pc.pcsearch.postgresql.repository.storage.SsdCellsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SsdCellsTypeServiceImpl implements SsdCellsTypeService {
    @Autowired
    SsdCellsTypeRepository ssdCellsTypeRepository;

    @Override
    public SsdCellsType create(SsdCellsType ssdCellsType) {
        return ssdCellsTypeRepository.save(ssdCellsType);
    }

    @Override
    public Optional<SsdCellsType> getOne(long id) {
        return ssdCellsTypeRepository.findById(id);
    }

    @Override
    public List<SsdCellsType> getAll() {
        return ssdCellsTypeRepository.findAll();
    }

    @Override
    public SsdCellsType update(SsdCellsType ssdCellsType, long id) {
        SsdCellsType temp = ssdCellsTypeRepository.findById(id).orElse(null);
        if(temp != null){
            temp.setName(ssdCellsType.getName());
            return ssdCellsTypeRepository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        ssdCellsTypeRepository.deleteById(id);
    }
}
