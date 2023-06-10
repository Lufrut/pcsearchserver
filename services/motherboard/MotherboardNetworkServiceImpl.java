package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardNetwork;
import com.pc.pcsearch.postgresql.repository.motherboard.MotherboardNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MotherboardNetworkServiceImpl implements MotherboardNetworkService {
    @Autowired
    MotherboardNetworkRepository networkRepository;

    @Override
    public MotherboardNetwork create(MotherboardNetwork network) {
        return networkRepository.save(network);
    }

    @Override
    public Optional<MotherboardNetwork> getOne(long id) {
        return networkRepository.findById(id);
    }

    @Override
    public List<MotherboardNetwork> getAll() {
        return networkRepository.findAll();
    }

    @Override
    public MotherboardNetwork update(MotherboardNetwork network, long id) {
        MotherboardNetwork temp = networkRepository.findById(id).orElse(null);
        if (temp != null) {
            return networkRepository.save(network);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        networkRepository.deleteById(id);
    }
}
