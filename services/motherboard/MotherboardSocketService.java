package com.pc.pcsearch.services.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardSocket;

import java.util.List;
import java.util.Optional;

public interface MotherboardSocketService {
    MotherboardSocket create(MotherboardSocket socket);

    Optional<MotherboardSocket> getOne(long id);

    List<MotherboardSocket> getAll();

    MotherboardSocket update(MotherboardSocket socket, long id);

    void delete(long id);
}
