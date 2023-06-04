package com.pc.pcsearch.services.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUConnector;
import com.pc.pcsearch.postgresql.repository.graphiccard.GPUConnectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GPUConnectorServiceImpl implements GPUConnectorService {
    @Autowired
    GPUConnectorRepository connectorRepository;

    @Override
    public GPUConnector create(GPUConnector connector) {
        return connectorRepository.save(connector);
    }

    @Override
    public Optional<GPUConnector> getOne(long id) {
        return connectorRepository.findById(id);
    }

    @Override
    public List<GPUConnector> getAll() {
        return connectorRepository.findAll();
    }

    @Override
    public GPUConnector update(GPUConnector connector, long id) {
        GPUConnector temp = connectorRepository.findById(id).orElse(null);
        if (temp != null) {
            return connectorRepository.save(connector);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        connectorRepository.deleteById(id);
    }
}
