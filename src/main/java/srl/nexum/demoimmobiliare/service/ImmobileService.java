package srl.nexum.demoimmobiliare.service;

import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.model.ImmobileQuotation;

import java.util.List;

public interface ImmobileService {

    public List<Immobile> findAll();
    public Immobile findById(String id);
    public void save(Immobile immobile);
    public ImmobileQuotation searchAndSave(Immobile immobile) throws Exception;
    public void delete(String id);
}

