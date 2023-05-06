package com.pc.pcsearch.postgresql.repository.powersupply;

import com.pc.pcsearch.models.buildpc.powersupply.PowerSupplyProducer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerSupplyProducerRepository extends JpaRepository<PowerSupplyProducer, Long> {
}
