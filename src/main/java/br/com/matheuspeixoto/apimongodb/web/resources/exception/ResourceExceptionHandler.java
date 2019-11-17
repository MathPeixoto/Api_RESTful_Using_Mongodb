package br.com.matheuspeixoto.apimongodb.web.resources.exception;

import br.com.matheuspeixoto.apimongodb.service.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(
      ObjectNotFoundException e, HttpServletRequest request) {
    HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    StandardError error =
        StandardError.builder()
            .timestamp(System.currentTimeMillis())
            .status(httpStatus.value())
            .error("Not found")
            .message(e.getMessage())
            .path(request.getRequestURI())
            .build();
    return new ResponseEntity<>(error, httpStatus);
  }
}
