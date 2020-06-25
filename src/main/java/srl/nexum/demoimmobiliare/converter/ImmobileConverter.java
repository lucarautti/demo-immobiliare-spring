package srl.nexum.demoimmobiliare.converter;

import org.springframework.stereotype.Component;

import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.dto.ImmobileDTO;

@Component
public class ImmobileConverter extends BaseConverter {

    public Immobile fill(ImmobileDTO dto){
        return convertToEntity(dto,Immobile.class);
    }

    public ImmobileDTO fill(Immobile entity){
        return convertToDto(entity,ImmobileDTO.class);
    }
}


