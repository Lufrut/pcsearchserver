package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CaseSize;
import com.pc.pcsearch.postgresql.repository.pccase.CaseSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseSizeServiceImpl implements CaseSizeService{
    @Autowired
    CaseSizeRepository repository;

    @Override
    public CaseSize create(CaseSize caseSize) {
        return repository.save(caseSize);
    }

    @Override
    public Optional<CaseSize> getOne(long id) {
        return repository.findById(id);
    }

    @Override
    public List<CaseSize> getAll() {
        return repository.findAll();
    }

    @Override
    public CaseSize update(CaseSize caseSize, long id) {
        CaseSize temp = repository.findById(id).orElse(null);
        if(temp != null){
            temp.setSize(caseSize.getSize());
            return repository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {

    }
}
