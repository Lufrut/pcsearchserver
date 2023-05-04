
package com.pc.pcsearch.services;

import com.pc.pcsearch.models.build_pc.BuildPc;
import com.pc.pcsearch.models.build_pc.Rating;
import com.pc.pcsearch.models.build_pc.cooler.Cooler;
import com.pc.pcsearch.models.build_pc.graphiccard.GraphicCard;
import com.pc.pcsearch.models.build_pc.motherboard.Motheboard;
import com.pc.pcsearch.models.build_pc.pcCase.Case;
import com.pc.pcsearch.models.build_pc.powerSupply.PowerSupply;
import com.pc.pcsearch.models.build_pc.processor.Processor;
import com.pc.pcsearch.models.build_pc.ram.Ram;
import com.pc.pcsearch.models.build_pc.storage.Hdd;
import com.pc.pcsearch.models.build_pc.storage.Ssd;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;


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
