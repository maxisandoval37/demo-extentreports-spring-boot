package ar.dev.maxisandoval.demoextentreportsspringboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraSumRestTest extends BaseTest{

    private final Calculadora calculadora = new Calculadora();

    @Test
    void testSumar() {
        assertEquals(5, calculadora.sumar(2, 3));
    }

    @Test
    void testRestar() {
        assertEquals(1, calculadora.restar(3, 2));
    }
}