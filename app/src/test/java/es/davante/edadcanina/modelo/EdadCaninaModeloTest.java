package es.davante.edadcanina.modelo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EdadCaninaModeloTest {
    @Test
    public void calculaCorrectamente() {
        EdadCaninaModelo modelo = new EdadCaninaModelo();
        modelo.setTexto("6");

        assertEquals(Validacion.CORRECTO, modelo.calcular());
        assertEquals(42, modelo.getEdadHumana());
    }

    @Test
    public void vacioDaError() {
        EdadCaninaModelo modelo = new EdadCaninaModelo();
        modelo.setTexto("");

        assertEquals(Validacion.VACIO, modelo.calcular());
    }

    @Test
    public void noEsNumeroDaError() {
        EdadCaninaModelo modelo = new EdadCaninaModelo();
        modelo.setTexto("abc");

        assertEquals(Validacion.NO_ES_NUMERO, modelo.calcular());
    }

    @Test
    public void fueraDeRangoDaError() {
        EdadCaninaModelo modelo = new EdadCaninaModelo();
        modelo.setTexto("31");

        assertEquals(Validacion.FUERA_DE_RANGO, modelo.calcular());
    }

}
