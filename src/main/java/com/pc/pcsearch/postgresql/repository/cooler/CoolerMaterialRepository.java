package com.pc.pcsearch.postgresql.repository.cooler;

import com.pc.pcsearch.models.buildpc.cooler.CoolerMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoolerMaterialRepository extends JpaRepository<CoolerMaterial, Long> {
}
