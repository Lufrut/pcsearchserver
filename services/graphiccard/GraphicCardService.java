package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;

import java.util.List;
import java.util.Optional;

public interface GraphicCardService {
    GraphicCard create(GraphicCard graphicCard);

    Optional<GraphicCard> getOne(long id);

    List<GraphicCard> getAll();

    GraphicCard update(GraphicCard graphicCard, long id);

    void delete(long id);
}
