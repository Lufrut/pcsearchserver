package com.pc.pcsearch.postgresql.repository;


import com.pc.pcsearch.models.buildpc.BuildPC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildPCRepository extends JpaRepository<BuildPC, Long> {

}