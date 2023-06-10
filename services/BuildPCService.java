
package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPC;


import java.util.List;
import java.util.Optional;

public interface BuildPCService {
    BuildPC create(BuildPC buildPC);

    Optional<BuildPC> getOne(long id);

    List<BuildPC> getAll();

    BuildPC update(BuildPC buildPC, long id);

    void delete(long id);
}
