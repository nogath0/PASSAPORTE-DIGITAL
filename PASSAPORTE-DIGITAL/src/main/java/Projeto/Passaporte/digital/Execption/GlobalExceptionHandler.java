package Projeto.Passaporte.digital.Execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<Map<String, String>> tratarEmailDuplicado(
            EmailJaCadastradoException exception) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", exception.getMessage()));
    }

    @ExceptionHandler(PerfilJaRegistrado.class)
    public ResponseEntity<Map<String, String>> TratarPerfilJaRegistrado(
            PerfilJaRegistrado exception) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", exception.getMessage()));
    }
}
