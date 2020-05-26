package srl.nexum.demoimmobiliare.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import srl.nexum.demoimmobiliare.model.Immobile;

public interface ImmobileRepository extends MongoRepository<Immobile, String> {
    List<Immobile> findByIndirizzo(String indirizzo);
    List<Immobile> findByMq(String mq);
}
