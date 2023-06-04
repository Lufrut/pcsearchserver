package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import com.pc.pcsearch.postgresql.repository.graphiccard.GraphicCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GraphicCardServiceImpl implements GraphicCardService {
    @Autowired
    GraphicCardRepository graphicCardRepository;

    @Override
    public GraphicCard create(GraphicCard graphicCard) {
        return graphicCardRepository.save(graphicCard);
    }

    @Override
    public Optional<GraphicCard> getOne(long id) {
        return graphicCardRepository.findById(id);
    }

    @Override
    public List<GraphicCard> getAll() {
        return graphicCardRepository.findAll();
    }

    @Override
    public GraphicCard update(GraphicCard graphicCard, long id) {
        GraphicCard temp = graphicCardRepository.findById(id).orElse(null);
        if (temp != null) {
            return graphicCardRepository.save(graphicCard);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        graphicCardRepository.deleteById(id);
    }
}
