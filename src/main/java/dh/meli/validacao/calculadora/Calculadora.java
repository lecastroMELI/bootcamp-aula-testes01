package dh.meli.validacao.calculadora;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculadora {

    private double n1, n2;

    // ESSE MÉTODO É UMA UNIDADE
    public double dividir() {
        if(n2 == 0) {
            return -1;
        } else {
            return n1 / n2;
        }
    }

}
