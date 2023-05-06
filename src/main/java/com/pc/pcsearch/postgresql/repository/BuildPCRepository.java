package com.pc.pcsearch.postgresql.repository;


import com.pc.pcsearch.models.buildpc.BuildPc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildPCRepository extends JpaRepository<BuildPc, Long> {

}