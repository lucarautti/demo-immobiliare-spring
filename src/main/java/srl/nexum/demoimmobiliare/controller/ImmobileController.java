package srl.nexum.demoimmobiliare.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import srl.nexum.demoimmobiliare.converter.ImmobileConverter;
import srl.nexum.demoimmobiliare.converter.ImmobileQuotationConverter;
import srl.nexum.demoimmobiliare.dto.ImmobileDTO;
import srl.nexum.demoimmobiliare.dto.ImmobileQuotationDTO;
import srl.nexum.demoimmobiliare.exceptions.ValidateException;
import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.model.ImmobileQuotation;
import srl.nexum.demoimmobiliare.service.ImmobileService;
import srl.nexum.demoimmobiliare.validator.ImmobileValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@CrossOrigin
@RestController
@RequestMapping(value = "/immobili")
public class ImmobileController extends BaseController{

    private static final Logger logger = LogManager.getLogger(ImmobileController.class);

    @Autowired
    private ImmobileService immobileServiceImpl;

    @Autowired
    ImmobileConverter immobileConverter;

    @Autowired
    ImmobileQuotationConverter immobileQuotationConverter;

    @Autowired
    ImmobileValidator immobileValidator;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ImmobileDTO>> getAll() throws Exception{
        logger.info("ImmobileController->getAll");

        List<ImmobileDTO> immobiliDTOList=new ArrayList<>();

        try{
            List<Immobile> immobiliList= immobileServiceImpl.findAll();

            immobiliList.stream().forEach(immobile -> {
                ImmobileDTO immobileDTO= immobileConverter.fill(immobile);
                immobiliDTOList.add(immobileDTO);
            });
        }catch(Exception e){
            logger.error("ImmobileController->getAll() Message: Errore-> " + e);
            throw new Exception(getMessageSource().getMessage("error.system.generic", null, Locale.getDefault()) + " - " + e.getMessage());
        }

        return new ResponseEntity<>(immobiliDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ImmobileDTO> getById(@PathVariable(value="id") String id) throws Exception{
        logger.info("ImmobileController->getById");

        ImmobileDTO immobileDTO =null;
        try{
            Immobile immobile= immobileServiceImpl.findById(id);

            if(immobile != null){
                immobileDTO = immobileConverter.fill(immobile);
            }
        }catch(Exception e){
            logger.error("ImmobileController->getById() Message: Errore-> " + e);
            throw new Exception(getMessageSource().getMessage("error.system.generic", null, Locale.getDefault()) + " - " + e.getMessage());
        }

        return new ResponseEntity<>(immobileDTO, HttpStatus.OK);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ImmobileQuotationDTO> save(@RequestBody ImmobileDTO immobileDTO) throws Exception{
        logger.info("ImmobileController->save");

        ImmobileQuotationDTO  immobileQuotationDTO;
        try{
            BindingResult resultErrors = new BeanPropertyBindingResult( immobileDTO, "immobileDTO" );
            immobileValidator.validate(immobileDTO, resultErrors);

            if(resultErrors.hasErrors()){
                try{
                    throw new ValidateException(resultErrors,getMessageSource());
                }catch (Exception e) {
                    logger.error("ImmobileController->save Message:Errore nella validazione dell'immobile.", e);

                    throw new Exception(getMessageSource().getMessage("error.system.generic.save.validation", null, Locale.getDefault()) + " - " + e.getMessage());
                }
            }

            Immobile immobile=immobileConverter.fill(immobileDTO);
            ImmobileQuotation immobileQuotation=immobileServiceImpl.searchAndSave(immobile);
            immobileQuotationDTO=immobileQuotationConverter.fill(immobileQuotation);
        }catch(Exception e){
            throw new Exception(getMessageSource().getMessage("error.system.generic", null, Locale.getDefault()) + " - " + e.getMessage());
        }

        return new ResponseEntity<>(immobileQuotationDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) throws Exception{
        logger.info("ImmobileController->delete");

        try{
            immobileServiceImpl.delete(id);
        }catch(Exception e){
            logger.error("ImmobileController->delete Message: Errore-> " + e);

            throw new Exception(getMessageSource().getMessage("error.system.generic", null, Locale.getDefault()) + " - " + e.getMessage());
        }

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping("/locale")
    public String locale() {
        return "locale";
    }
}
