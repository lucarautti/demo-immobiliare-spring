package srl.nexum.demoimmobiliare.converter;

import org.apache.logging.log4j.Logger;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.dto.ImmobileDTO;

import java.math.BigDecimal;

@Component
public class BaseConverter {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(BaseConverter.class);

    @Autowired
    private ModelMapper modelMapper;

    protected <T extends Immobile, E extends ImmobileDTO> E convertToDto(T entity, Class<E> dtoClass) {
        E dto=null;
        try{
            dto = modelMapper.map(entity, dtoClass);
        }catch(Exception e){
            logger.error("BaseController->convertToDto Message: Errore-> " + e);
        }
        return dto;
    }

    protected <T extends ImmobileDTO, E extends Immobile> E convertToEntity(T dto, Class<E> entityClazz) {
        E entity=null;
        modelMapper.addConverter(stringToBigDecimal);
        entity = modelMapper.map(dto, entityClazz);
        return entity;
    }

    Converter<String, BigDecimal> stringToBigDecimal = new AbstractConverter<String, BigDecimal>() {
        protected BigDecimal convert(String source){
            BigDecimal value=null;
            try{
                //value= source == null ? null : GenericUtils.convertStringToBigDecimal(source);
                value= source == null ? null :new BigDecimal(source);
            }  catch (Exception pa){ pa.printStackTrace();}
            return value;
        }
    };

}
