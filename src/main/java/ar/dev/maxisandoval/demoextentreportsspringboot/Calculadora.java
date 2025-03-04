package ar.dev.maxisandoval.demoextentreportsspringboot;

import lombok.*;

@NoArgsConstructor
@Data
class Calculadora {
    private int resultado;

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        return a / b;
    }
}