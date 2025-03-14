package in.springrestapi.Exceptions;

import jdk.jshell.Snippet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
     @Override
     protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
         Map<String,Object> body = new LinkedHashMap<String, Object>();
         body.put("timesStamp",System.currentTimeMillis());
         body.put("statusCode", status.value());

         //Adding the error messages

         List<String> errors = ex.getBindingResult()
                 .getFieldErrors()
                 .stream()
                 .map(x->x.getDefaultMessage())
                 .collect(Collectors.toList());

                body.put("errors",errors);
                return new ResponseEntity<Object>(body,status);
     }
 }
