package com.pc.pcsearch.postgresql.repository.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProtectionFunctions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerSupplyProtectionFunctionsRepository extends JpaRepository<PowerSupplyProtectionFunctions, Long> {
}
