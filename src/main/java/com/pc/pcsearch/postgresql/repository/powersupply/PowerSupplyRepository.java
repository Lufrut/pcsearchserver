package com.pc.pcsearch.postgresql.repository.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {
}
