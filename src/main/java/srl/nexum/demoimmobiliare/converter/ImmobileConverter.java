package srl.nexum.demoimmobiliare.converter;

import org.springframework.stereotype.Component;

import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.dto.ImmobileDTO;

@Component
public class ImmobileConverter extends BaseConverter {

    public Immobile fill(ImmobileDTO dto) throws Exception{
        Immobile entity=convertToEntity(dto,Immobile.class);
        return entity;
    }

    public ImmobileDTO fill(Immobile entity)throws Exception{
        ImmobileDTO dto = convertToDto(entity,ImmobileDTO.class);
        return dto;
    }
}


