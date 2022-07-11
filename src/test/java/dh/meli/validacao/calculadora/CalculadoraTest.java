package dh.meli.validacao.calculadora;

import dh.meli.validacao.util.CalculadoraCreate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    // Antes de rodar os testes, será criado o objeto para cada método
    @BeforeEach // antes de cada teste, roda esse método (setup)
    public void setup() { // o nome dele poderia ser qualquer nome, conveção usar setup

        /* Uma forma de implementar, antes da criação da pasta util */
        // calculadora = new Calculadora();

        calculadora = CalculadoraCreate.create(); // depois da pasta util
    }

    // DEVE-SE TER UM TESTE PARA CADA SITUAÇÃO DO MÉTODO, OU SEJA, PARA CADA RETORNO DO MÉTODO
    // CADA TESTE DEVE SER SEMPRE INDEPENDENTE UM DO OUTRO

    @Test // indicação que vai testar algo
    @DisplayName("Valida parâmetros diferentes de zero")
    void dividir_ReturnValueDouble_WhenParamDifferentZero() {
        /* CÓDIGO COMENTADO CORRESPONDE A IMPLEMENTAÇÃO ANTES DO SETUP FIXO (A PASTA ÚTIL) */

        // Calculadora calculadora = new Calculadora(); // BeforeEach criar esse objeto
        // double a = 4;
        // double b = 2;
        // double expected = 2; // o resultado esperado da divisão
        double expected = CalculadoraCreate.create().getN1() / CalculadoraCreate.create().getN2();

        // Chamada do método já está em execução
        // double resultado = calculadora.dividir(a, b);
        double resultado = calculadora.dividir();

        // Avaliar o resultado. Testar de fato
        Assertions.assertEquals(expected, resultado);

        // posso ter vários assertions
    }

    @Test // indicação que vai testar algo
    @DisplayName("Valida se retorna -1, quando N2 = 0")
    void dividir_ReturnValueDouble_WhenParamEqualZero() {
        /* CÓDIGO COMENTADO CORRESPONDE A IMPLEMENTAÇÃO ANTES DO SETUP FIXO (A PASTA ÚTIL) */

        // Calculadora calculadora = new Calculadora(); // BeforeEach criar esse objeto
        // double a = 4;
        // double b = 0;
        // double expected = -1; // o resultado esperado da divisão

        double expected = -1;
        calculadora.setN2(0); // necessário setar um dos parâmetros com zero para poder testar a divisão por zero

        // Chamada do método já está em execução
        // double resultado = calculadora.dividir(a, b);
        double resultado = calculadora.dividir();

        // Avaliar o resultado. Testar de fato
        assertEquals(expected, resultado);
    }
}