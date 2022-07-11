package dh.meli.validacao.exception;

// ESTA CUIDA DE SOBRESCREVER OS ERROS TRATADOS PELO SPRING, PARA MOSTRAR A MENSAGEM DE FORMA MAIS AMIGÁVEL PARA O USER

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


// TRATA UMA EXCEÇÃO QUANDO O ARGUMENTO NÃO É VÁLIDO.
// O ERRO PADRÃO ESTÁ SENDO SUBSTITUÍDO POR ESSE TRATAMENTO QUE FOI DETERMINADO AQUI
// CONTENDO AS INFORMAÇÕES PERSONALIZADAS
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request) {
        // Capturar os erros da exceção
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        return new ResponseEntity<>(
            // 1º PARÂMETRO DO RESONSE ENTITY É O "RETORNO"
            //DEVOLVER apenas os erros com as mensagens personalizadas
            ValidationEx.builder()
                .timestamp(LocalDateTime.now())
                .title("Campos inválidos")
                .message(ex.getClass().getName())
                // Todos os campos que estão na lista de erros.
                // Retorna uma lista de nomes e concatena todos os nomes separados com ;
                .fields(errors.stream().map(FieldError::getField)
                    .collect(Collectors.joining("; ")))
                    // para cada um desses campos pega a MENSAGEM de erro de cada um desses campos
                    .fieldsMessages(errors.stream().map(FieldError::getDefaultMessage)
                        // concatena numa lista e separa com ;
                        .collect(Collectors.joining("; ")))
                // Sempre que usar o builder() deve finalizar com build()
                .build()
            // 2º PARÂMETRO DO RESPONSE ENTITY É O "STATUS"
            , HttpStatus.BAD_REQUEST
        );
    }
}
