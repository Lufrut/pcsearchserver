package com.pc.pcsearch.postgresql.repository.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardChipset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherboardChipsetRepository extends JpaRepository<MotherboardChipset, Long> {
}
