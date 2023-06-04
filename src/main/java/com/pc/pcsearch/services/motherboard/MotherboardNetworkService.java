package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardNetwork;

import java.util.List;
import java.util.Optional;

public interface MotherboardNetworkService {
    MotherboardNetwork create(MotherboardNetwork network);

    Optional<MotherboardNetwork> getOne(long id);

    List<MotherboardNetwork> getAll();

    MotherboardNetwork update(MotherboardNetwork network, long id);

    void delete(long id);
}