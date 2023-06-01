package com.pc.pcsearch.services.cooler;

import com.pc.pcsearch.models.buildpc.cooler.CoolerSocket;
import com.pc.pcsearch.postgresql.repository.cooler.CoolerSocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoolerSocketServiceImpl implements CoolerSocketService{
    @Autowired
    CoolerSocketRepository coolerSocketRepository;

    @Override
    public CoolerSocket create(CoolerSocket coolerSocket) {
        return coolerSocketRepository.save(coolerSocket);
    }

    @Override
    public Optional<CoolerSocket> getOne(long id) {
        return coolerSocketRepository.findById(id);
    }

    @Override
    public List<CoolerSocket> getAll() {
        return coolerSocketRepository.findAll();
    }

    @Override
    public CoolerSocket update(CoolerSocket coolerSocket, long id) {
        CoolerSocket temp = coolerSocketRepository.findById(id).orElse(null);
        if(temp != null) {
            temp.setSocket(coolerSocket.getSocket());
            return coolerSocketRepository.save(temp);
        } else return null;
    }

    @Override
    public void delete(long id) {
        coolerSocketRepository.deleteById(id);
    }
}
