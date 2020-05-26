package srl.nexum.demoimmobiliare.service;

import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srl.nexum.demoimmobiliare.dto.ImmobileDTO;
import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.repository.ImmobileRepository;

import java.util.UUID;

@Service
public class ImmobileServiceImpl implements ImmobileService {

    @Autowired
    private ImmobileRepository immobileRepository;

    @Override
    public Immobile getImmobileById(UUID id) {
        if (immobileRepository.findById(id).isPresent())
            return immobileRepository.findById(id).get();
        else
            throw new MongoException("Immobile non trovato");
    }

    @Override
    public Immobile createImmobile(ImmobileDTO immobileDTO) {
        Immobile immobile = new Immobile(immobileDTO.getIndirizzo(), immobileDTO.getMq());
        return immobileRepository.save(immobile);
    }

    @Override
    public Immobile updateImmobile(ImmobileDTO immobileDTO, UUID id) {
        if (immobileRepository.findById(id).isPresent()){
            Immobile existingImmobile = immobileRepository.findById(id).get();
            existingImmobile.setIndirizzo(immobileDTO.getIndirizzo());
            existingImmobile.setMq(immobileDTO.getMq());
            return immobileRepository.save(existingImmobile);
        }
        else
            throw new MongoException("Immobile non trovato");
    }

    @Override
    public Immobile deleteImmobileById(UUID id) {
        if (immobileRepository.findById(id).isPresent()) {
            Immobile immobile = immobileRepository.findById(id).get();
            immobileRepository.delete(immobile);
            return immobile;
        }
        else
            throw new MongoException("Immobile non trovato");
    }


}
