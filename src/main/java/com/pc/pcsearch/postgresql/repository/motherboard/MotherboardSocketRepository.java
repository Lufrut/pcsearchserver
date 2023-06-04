package com.pc.pcsearch.postgresql.repository.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardSocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherboardSocketRepository extends JpaRepository<MotherboardSocket, Long> {
}
