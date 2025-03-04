package ar.dev.maxisandoval.demoextentreportsspringboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraMultDivTest extends BaseTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
    }

    @Test
    void testDividir() {
        assertEquals(1, calculadora.dividir(3, 3));
    }
}