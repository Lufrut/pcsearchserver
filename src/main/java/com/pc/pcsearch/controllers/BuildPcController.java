package com.pc.pcsearch.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pc.pcsearch.models.build_pc.BuildPc;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BuildPcController {

    @Autowired
    BuildPCRepository buildPCRepository;

}