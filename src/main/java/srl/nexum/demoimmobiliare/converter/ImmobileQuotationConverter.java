package srl.nexum.demoimmobiliare.converter;

import org.springframework.stereotype.Component;
import srl.nexum.demoimmobiliare.dto.ImmobileDTO;
import srl.nexum.demoimmobiliare.dto.ImmobileQuotationDTO;
import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.model.ImmobileQuotation;

@Component
public class ImmobileQuotationConverter extends BaseConverter {

    public ImmobileQuotation fill(ImmobileQuotationDTO dto) throws Exception{
        return convertToEntity(dto,ImmobileQuotation.class);
    }

    public ImmobileQuotationDTO fill(ImmobileQuotation entity)throws Exception{
        return convertToDto(entity,ImmobileQuotationDTO.class);
    }
}
