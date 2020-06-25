package srl.nexum.demoimmobiliare.exceptions;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BindingResult;

public class ValidateException extends Exception {
    private static final long serialVersionUID = 1L;

    private String errorMessage;
    private ReloadableResourceBundleMessageSource messageSource;
    private BindingResult resultErrors;

    public ValidateException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ValidateException(BindingResult resultErrors, ReloadableResourceBundleMessageSource messageSource) {
        this.resultErrors=resultErrors;
        this.messageSource=messageSource;
    }

    public ValidateException() {
        super();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ReloadableResourceBundleMessageSource getMessageSource() {
        return messageSource;
    }

    public BindingResult getResultErrors() {
        return resultErrors;
    }
}
