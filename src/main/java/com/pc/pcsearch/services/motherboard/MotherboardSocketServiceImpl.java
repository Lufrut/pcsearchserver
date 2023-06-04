package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardSocket;
import com.pc.pcsearch.postgresql.repository.motherboard.MotherboardSocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MotherboardSocketServiceImpl implements MotherboardSocketService {
    @Autowired
    MotherboardSocketRepository socketRepository;

    @Override
    public MotherboardSocket create(MotherboardSocket socket) {
        return socketRepository.save(socket);
    }

    @Override
    public Optional<MotherboardSocket> getOne(long id) {
        return socketRepository.findById(id);
    }

    @Override
    public List<MotherboardSocket> getAll() {
        return socketRepository.findAll();
    }

    @Override
    public MotherboardSocket update(MotherboardSocket socket, long id) {
        MotherboardSocket temp = socketRepository.findById(id).orElse(null);
        if (temp != null) {
            return socketRepository.save(socket);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        socketRepository.deleteById(id);
    }
}