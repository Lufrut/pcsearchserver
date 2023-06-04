package com.pc.pcsearch.postgresql.repository.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GraphicCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphicCardRepository extends JpaRepository<GraphicCard, Long> {
}
