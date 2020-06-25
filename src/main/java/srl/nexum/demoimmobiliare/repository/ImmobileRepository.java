package srl.nexum.demoimmobiliare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import srl.nexum.demoimmobiliare.model.Immobile;

//@RepositoryRestResource(collectionResourceRel = "immobili", path = "immobili")
public interface ImmobileRepository extends MongoRepository<Immobile, String> {
    Immobile findByNameContaining(final String name);
}