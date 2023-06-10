package com.pc.pcsearch.services.processor;

import java.util.List;
import java.util.Optional;

import com.pc.pcsearch.models.buildpc.processor.Processor;
import com.pc.pcsearch.postgresql.repository.processor.ProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessorServiceImpl implements ProcessorService {
    @Autowired
    ProcessorRepository processorRepository;

    @Override
    public Processor create(Processor processor) {
        return processorRepository.save(processor);
    }

    @Override
    public Optional<Processor> getOne(long id) {
        return processorRepository.findById(id);
    }

    @Override
    public List<Processor> getAll() {
        return processorRepository.findAll();
    }

    @Override
    public Processor update(Processor processor, long id) {
        Processor temp = processorRepository.findById(id).orElse(null);
        if (temp != null) {
            temp = processor;
            return processorRepository.save(temp);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        processorRepository.deleteById(id);
    }
}