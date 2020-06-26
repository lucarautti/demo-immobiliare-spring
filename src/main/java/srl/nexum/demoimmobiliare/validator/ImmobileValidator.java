package srl.nexum.demoimmobiliare.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import srl.nexum.demoimmobiliare.dto.ImmobileDTO;

@Component("ImmobileValidator")
public class ImmobileValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ImmobileDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ImmobileDTO immobileDTO = (ImmobileDTO) target;

        validateMandatory(immobileDTO, errors);
        if(errors.getErrorCount() == 0){
            validateIncorrect(immobileDTO, errors);
        }
    }

    public void validateMandatory(ImmobileDTO immobileDTO, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.immobile.address.mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.immobile.city.mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "latitude", "error.immobile.latitude.mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "longitude", "error.immobile.longitude.mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stato", "error.immobile.stato.mandatory");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione_tipologia", "error.immobile.descrizione_tipologia.mandatory");
    }

    public void validateIncorrect(ImmobileDTO immobileDTO, Errors errors) {
    }
}
