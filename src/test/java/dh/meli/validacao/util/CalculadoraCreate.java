package dh.meli.validacao.util;

import dh.meli.validacao.calculadora.Calculadora;
import lombok.Data;

// CLASSE SERVINDO COMO UM SETUP FIXO
// OU SEJA, LOCAL ONDE DEFINO INFORMAÇÕES FIXAS QUE SERÃO USADAS NOS TESTES (lembra a ideia de mock)
@Data
public class CalculadoraCreate {
    // concentro aqui os dados que vou precisar usar nos testes

    private static double n1 = 4, n2 = 2;

    public static Calculadora create() {
        return new Calculadora(n1, n2);
    }

//    public static Calculadora createValid() {
//        return new Calculadora(n1, n2);
//    }
//
//    public static Calculadora createWithZero() {
//        return new Calculadora(n1, 0);
//    }

}
