package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.Case;
import com.pc.pcsearch.postgresql.repository.pccase.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseServiceImpl  implements CaseService{
    @Autowired
    CaseRepository repository;

    @Override
    public Case create(Case item) {
        return repository.save(item);
    }

    @Override
    public Optional<Case> getOne(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Case> getAll() {
        return repository.findAll();
    }

    @Override
    public Case update(Case item, long id) {
        Case temp = repository.findById(id).orElse(null);
        if(temp != null && item.getId() == id){
            return repository.save(item);
        } else return null;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
