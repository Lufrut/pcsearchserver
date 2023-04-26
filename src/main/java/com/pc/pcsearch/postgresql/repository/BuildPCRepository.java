package com.pc.pcsearch.postgresql.repository;


import com.pc.pcsearch.models.build_pc.BuildPc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildPCRepository extends JpaRepository<BuildPc, Long>{

}