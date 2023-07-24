package utp.edu.co.zonaspromisorias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import utp.edu.co.zonaspromisorias.exceptions.types.BadRequestException;
import utp.edu.co.zonaspromisorias.exceptions.types.NotFoundException;
import utp.edu.co.zonaspromisorias.exceptions.types.UnprocessableEntityException;

import java.util.Date;

/**
 * Clase manejo de excepciones.
 *
 * @author Juan Chavarro
 */
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Clase controlador de manejo de excepcion bad request.
     *
     * @param ex      excepcion recibida.
     * @param request request web.
     * @return Respuesta de excepcion.
     */
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(final NotFoundException ex,
                                                                             final WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Clase controlador de manejo de excepcion not found.
     *
     * @param ex      excepcion recibida.
     * @param request request web.
     * @return Respuesta de excepcion.
     */
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(final NotFoundException ex,
                                                                           final WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Clase controlador de manejo de excepcion unprocessable.
     *
     * @param ex      excepcion recibida.
     * @param request request web.
     * @return Respuesta de excepcion.
     */
    @ExceptionHandler(UnprocessableEntityException.class)
    public final ResponseEntity<ExceptionResponse> handleUnprocessableEntityException(final NotFoundException ex,
                                                                                      final WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
