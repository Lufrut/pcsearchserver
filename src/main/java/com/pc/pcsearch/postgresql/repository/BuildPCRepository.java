package com.pc.pcsearch.postgresql.repository;


import com.pc.pcsearch.models.buildpc.BuildPc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "BuildPC", path = "buildpc")
public interface BuildPCRepository extends JpaRepository<BuildPc, Long> {

}