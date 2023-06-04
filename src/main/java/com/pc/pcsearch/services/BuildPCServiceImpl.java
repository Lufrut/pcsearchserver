package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildPCServiceImpl implements BuildPCService {
    @Autowired
    BuildPCRepository buildPCRepository;

    @Override
    public BuildPC create(BuildPC buildPC) {
        return buildPCRepository.save(buildPC);
    }

    @Override
    public Optional<BuildPC> getOne(long id) {
        return buildPCRepository.findById(id);
    }

    @Override
    public List<BuildPC> getAll() {
        return buildPCRepository.findAll();
    }

    @Override
    public BuildPC update(BuildPC buildPC, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if (temp != null) {
            return buildPCRepository.save(buildPC);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        buildPCRepository.deleteById(id);
    }
}
