
package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPc;


public interface BuildPCService {
    BuildPc createBuildPc(
            String nameOfBuild,
            int userId,
            int motherboardId,
            int processorId,
            int graphicCardId,
            int[] ramId,
            int powerSupplyId,
            int[] hddId,
            int[] ssdId,
            int pcCase,
            int coolerId
    );

}
