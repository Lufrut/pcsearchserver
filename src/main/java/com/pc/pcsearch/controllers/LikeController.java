package com.pc.pcsearch.controllers;

import com.pc.pcsearch.models.buildpc.Like;
import com.pc.pcsearch.services.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping("/admin/like")
    public Like create(@Valid @RequestBody Like like) {
        return likeService.create(like);
    }

    @GetMapping("/all/like/{id}")
    public Optional<Like> getOne(@PathVariable long id) {
        return likeService.getOne(id);
    }

    @GetMapping("/all/like")
    public List<Like> getAll() {
        return likeService.getAll();
    }

    @PutMapping("/admin/like/{id}")
    public Like update(@Valid @RequestBody Like like, @PathVariable long id) {
        return likeService.update(like, id);
    }

    @DeleteMapping("/admin/like/{id}")
    public String delete(@PathVariable long id) {
        likeService.delete(id);
        return "Successfully deleted";
    }
}
