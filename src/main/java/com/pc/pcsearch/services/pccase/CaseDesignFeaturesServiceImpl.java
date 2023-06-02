package com.pc.pcsearch.services.pccase;

import com.pc.pcsearch.models.buildpc.pccase.CaseDesignFeatures;
import com.pc.pcsearch.postgresql.repository.pccase.CaseDesignFeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseDesignFeaturesServiceImpl implements CaseDesignFeaturesService{
    @Autowired
    CaseDesignFeaturesRepository repository;
    @Override
    public CaseDesignFeatures create(CaseDesignFeatures designFeatures) {
        return repository.save(designFeatures);
    }

    @Override
    public Optional<CaseDesignFeatures> getOne(long id) {
        return repository.findById(id);
    }

    @Override
    public List<CaseDesignFeatures> getAll() {
        return repository.findAll();
    }

    @Override
    public CaseDesignFeatures update(CaseDesignFeatures designFeatures, long id) {
        CaseDesignFeatures temp = repository.findById(id).orElse(null);
        if(temp != null){
            temp.setDesignFeatures(designFeatures.getDesignFeatures());
            return repository.save(temp);
        }  else return null;
    }

    @Override
    public void delete(long id) {
        repository.findById(id);
    }
}
