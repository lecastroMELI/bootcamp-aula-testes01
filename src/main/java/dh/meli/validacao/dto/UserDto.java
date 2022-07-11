package dh.meli.validacao.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data // Getter, Setter
public class UserDto {

    // MAPEAR COMO OS CAMPOS DEVEM SER VALIDADOS. GARANTIR QUE OS DADOS QUE CHEGAM PELO CONTROLLER
    // ESTÃO NO FORMATO DESEJADO DE ACORDO COM AS REGRAS

    // A ORDEM DAS ANOTAÇÕES NÃO IMPORTA

    // A ANOTAÇÃO SEMPRE ANOTARÁ O CAMPO IMEDIATAMENTE ABAIXO

    // CAMPO OBRIGATÓRIO

    /* @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ/s]+", message = "O nome do aluno deve começar com letra maiúscula.") */

    // @NotNull // campo tem que existir, mas não verifica o que está dentro dele
    // @NotEmpty // alem de não nulo, não vazio
    @NotBlank(message = "O nome é obrigatório") // faz os dois acima . Necessário usar o @Valid no controller, onde deve
    private String name;

    @NotBlank(message = "O e-mail é obrigatório!")
    @Email(message = "Formato email@dominio.com") // para tornar o campo um formato de email
    private String email;

    // CAMPOS NUMÉRICOS PODEM TER UM INTERVALO DEFINIDO
    @Min(value = 18, message = "A idade mínima é 18 anos")
    private int age;
}
/*
* @DecimalMax(value = "10.0", message = "A nota máxima da disciplina é de 10 pontos.")*/