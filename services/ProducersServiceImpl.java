package com.pc.pcsearch.services;
import com.pc.pcsearch.models.buildpc.Producers;
import com.pc.pcsearch.postgresql.repository.ProducersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProducersServiceImpl implements ProducersService {
    @Autowired
    ProducersRepository producersRepository;

    @Override
    public Producers create(Producers producers) {
        return producersRepository.save(producers);
    }

    @Override
    public Optional<Producers> getOne(long id) {
        return producersRepository.findById(id);
    }

    @Override
    public List<Producers> getAll() {
        return producersRepository.findAll();
    }

    @Override
    public Producers update(Producers producers, long id) {
        Producers temp = producersRepository.findById(id).orElse(null);
        if (temp != null) {
            temp = producers;
            return producersRepository.save(temp);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        producersRepository.deleteById(id);
    }
}