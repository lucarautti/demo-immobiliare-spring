package srl.nexum.demoimmobiliare.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class HousequotExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorResponse> exceptionNotFoundHandler(Exception ex) {
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.NOT_FOUND.value());
		errore.setMessaggio(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errore, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BindingException.class)
	public ResponseEntity<ErrorResponse> exceptionBindingHandler(Exception ex){
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.BAD_REQUEST.value());
		errore.setMessaggio(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errore, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<ErrorResponse> exceptionDeplicateRecordHandler(Exception ex){
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.NOT_ACCEPTABLE.value());
		errore.setMessaggio(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errore, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = ValidateException.class)
	public ResponseEntity<ErrorResponse> validationExceptionHandler(ValidateException ex, WebRequest request) {
		ErrorResponse errore = new ErrorResponse();

		errore.setCodice(HttpStatus.BAD_REQUEST.value());
		errore.setMessaggio(ex.getMessage());

		return new ResponseEntity<ErrorResponse>(errore, HttpStatus.BAD_REQUEST);

		/*ErrorMessages errors= Utils.getValidationErrors(ex.getResultErrors(),ex.getMessageSource());
		return errors;*/
	}
}
