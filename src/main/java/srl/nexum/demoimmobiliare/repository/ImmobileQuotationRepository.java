package srl.nexum.demoimmobiliare.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import srl.nexum.demoimmobiliare.model.ImmobileQuotation;

public interface ImmobileQuotationRepository extends MongoRepository<ImmobileQuotation, String> {
}
