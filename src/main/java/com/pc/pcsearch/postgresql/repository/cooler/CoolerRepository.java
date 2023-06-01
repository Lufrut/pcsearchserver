package com.pc.pcsearch.postgresql.repository.cooler;

import com.pc.pcsearch.models.buildpc.cooler.Cooler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoolerRepository extends JpaRepository<Cooler, Long> {
}
