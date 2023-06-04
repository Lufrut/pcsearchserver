package com.pc.pcsearch.postgresql.repository.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherboardNetworkRepository extends JpaRepository<MotherboardNetwork, Long> {
}
