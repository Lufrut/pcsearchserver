package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CasePowerSupplyLocation;
import com.pc.pcsearch.postgresql.repository.pccase.CasePowerSupplyLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasePowerSupplyLocationServiceImpl implements CasePowerSupplyLocationService{
    @Autowired
    CasePowerSupplyLocationRepository repository;
    @Override
    public CasePowerSupplyLocation create(CasePowerSupplyLocation location) {
        return repository.save(location);
    }

    @Override
    public Optional<CasePowerSupplyLocation> getOne(long id) {
        return repository.findById(id);
    }

    @Override
    public List<CasePowerSupplyLocation> getAll() {
        return repository.findAll();
    }

    @Override
    public CasePowerSupplyLocation update(CasePowerSupplyLocation location, long id) {
        CasePowerSupplyLocation temp = repository.findById(id).orElse(null);
        if(temp != null){
            temp.setPowerSupplyLocation(location.getPowerSupplyLocation());
            return repository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
