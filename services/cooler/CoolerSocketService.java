package com.pc.pcsearch.services.cooler;

import com.pc.pcsearch.models.buildpc.cooler.CoolerSocket;

import java.util.List;
import java.util.Optional;

public interface CoolerSocketService {
    CoolerSocket create(CoolerSocket coolerSocket);

    Optional<CoolerSocket> getOne(long id);

    List<CoolerSocket> getAll();

    CoolerSocket update(CoolerSocket coolerSocket, long id);

    void delete(long id);
 }
