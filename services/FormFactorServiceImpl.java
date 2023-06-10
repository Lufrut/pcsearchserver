package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.postgresql.repository.FormFactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormFactorServiceImpl implements FormFactorService {
    @Autowired
    FormFactorRepository formFactorRepository;

    @Override
    public FormFactor create(FormFactor formFactor) {
        return formFactorRepository.save(formFactor);
    }

    @Override
    public Optional<FormFactor> getOne(long id) {
        return formFactorRepository.findById(id);
    }

    @Override
    public List<FormFactor> getAll() {
        return formFactorRepository.findAll();
    }

    @Override
    public FormFactor update(FormFactor formFactor, long id) {
        FormFactor temp = formFactorRepository.findById(id).orElse(null);
        if (temp != null) {
            temp = formFactor;
            return formFactorRepository.save(temp);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        formFactorRepository.deleteById(id);
    }
}