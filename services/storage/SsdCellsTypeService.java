package com.pc.pcsearch.services.storage;

import com.pc.pcsearch.models.buildpc.storage.SsdCellsType;

import java.util.List;
import java.util.Optional;

public interface SsdCellsTypeService {
    SsdCellsType create(SsdCellsType ssdCellsType);

    Optional<SsdCellsType> getOne(long id);

    List<SsdCellsType> getAll();

    SsdCellsType update(SsdCellsType ssdCellsType, long id);

    void delete(long id);
}
