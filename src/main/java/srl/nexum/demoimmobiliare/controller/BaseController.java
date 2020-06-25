package srl.nexum.demoimmobiliare.controller;

import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@RestController
@RequestMapping(value ="base")
public class BaseController {

    /**
     * Logger for this class
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(BaseController.class);

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    private ModelMapper modelMapper;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public ReloadableResourceBundleMessageSource getMessageSource() {
        return messageSource;
    }
}
