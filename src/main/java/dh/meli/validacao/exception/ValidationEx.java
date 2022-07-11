package dh.meli.validacao.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
// CLASSE RESPONSÁVEL POR DEFINIR OS CAMPOS PERSONALIZADOS
public class ValidationEx {
    // OS CAMPOS QUE DEVERÃO APARECER NA MENSAGEM
    private String title;
    private String message;
    private String fields;
    private String fieldsMessages;
    private LocalDateTime timestamp;
}
