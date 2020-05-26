package srl.nexum.demoimmobiliare.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import srl.nexum.demoimmobiliare.model.Immobile;

public interface ImmobileRepository extends MongoRepository<Immobile, UUID> {
    List<Immobile> findByIndirizzo(String indirizzo);
}
