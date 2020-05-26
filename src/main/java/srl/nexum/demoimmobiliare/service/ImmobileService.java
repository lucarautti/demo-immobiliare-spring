package srl.nexum.demoimmobiliare.service;

import java.util.UUID;

import srl.nexum.demoimmobiliare.dto.ImmobileDTO;
import srl.nexum.demoimmobiliare.model.Immobile;

public interface ImmobileService {

    public Immobile getImmobileById(UUID id);
    public Immobile createImmobile(ImmobileDTO immobileDTO);
    public Immobile updateImmobile(ImmobileDTO immobileDTO, UUID id);
    public Immobile deleteImmobileById(UUID id);
}
