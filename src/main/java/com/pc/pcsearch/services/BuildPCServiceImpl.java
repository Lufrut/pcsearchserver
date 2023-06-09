package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.models.buildpc.Rating;
import com.pc.pcsearch.models.buildpc.User;
import com.pc.pcsearch.postgresql.repository.BuildPCRepository;
import com.pc.pcsearch.postgresql.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildPCServiceImpl implements BuildPCService {
    @Autowired
    BuildPCRepository buildPCRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public BuildPC create(BuildPC req) {
        BuildPC buildPC = new BuildPC();
        buildPC.setTotalPrice(0);
        buildPC.setUser(req.getUser());
        buildPC.setPcCase(req.getPcCase());
        buildPC.setSsd(req.getSsd());
        buildPC.setHdd(req.getHdd());
        buildPC.setPowerSupply(req.getPowerSupply());
        buildPC.setRam(req.getRam());
        buildPC.setProcessor(req.getProcessor());
        buildPC.setCooler(req.getCooler());
        buildPC.setNameOfBuild(req.getNameOfBuild());
        buildPC.setGraphicCard(req.getGraphicCard());
        buildPC.setMotherboard(req.getMotherboard());
        buildPC.setCountOfLikes(0);
        Rating rating = new Rating();
        buildPCRepository.saveAndFlush(buildPC);
        rating.setBuildPc(buildPC);
        BuildPC temp = buildPCRepository.findById(buildPC.getId()).orElse(null);
        assert temp != null;
        temp.setRatingId(ratingRepository.save(rating));
        return buildPCRepository.save(temp);
    }

    @Override
    public Optional<BuildPC> getOne(long id) {
        return buildPCRepository.findById(id);
    }

    @Override
    public List<BuildPC> getAll() {
        return buildPCRepository.findAll();
    }

    @Override
    public BuildPC update(BuildPC buildPC, long id) {
        BuildPC temp = buildPCRepository.findById(id).orElse(null);
        if (temp != null) {
            return buildPCRepository.save(buildPC);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        buildPCRepository.deleteById(id);
    }
}
