package com.pc.pcsearch.controllers.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import com.pc.pcsearch.services.graphiccard.GraphicCardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class GraphicCardController {
    @Autowired
    GraphicCardService graphicCardService;

    @PostMapping("/admin/graphicCard")
    public GraphicCard create(@Valid  @RequestBody GraphicCard graphicCard) {
        return graphicCardService.create(graphicCard);
    }

    @GetMapping("/all/graphicCard/{id}")
    public Optional<GraphicCard> getOne(@PathVariable long id) {
        return graphicCardService.getOne(id);
    }

    @GetMapping("/all/graphicCard")
    public List<GraphicCard> getAll() {
        return graphicCardService.getAll();
    }

    @PutMapping("/admin/graphicCard/{id}")
    public GraphicCard update(@Valid @RequestBody GraphicCard graphicCard, @PathVariable long id) {
        return graphicCardService.update(graphicCard, id);
    }

    @DeleteMapping("/admin/graphicCard/{id}")
    public String delete(@PathVariable long id) {
        graphicCardService.delete(id);
        return "Successfully deleted";
    }
}

