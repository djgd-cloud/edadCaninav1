package es.davante.edadcanina.modelo;

public class EdadCaninaModelo {
    private String texto = "";
    private int edadHumana;
    private Validacion validacion = Validacion.SIN_CALCULAR;

    public void setTexto(String texto) {
        this.texto = texto;
        validacion = Validacion.SIN_CALCULAR;
    }

    public String getTexto() {
        return texto;
    }

    public int getEdadHumana() {
        return edadHumana;
    }

    public Validacion getValidacion() {
        return validacion;
    }

    // Comprueba el texto y, si es correcto, calcula la edad
    public Validacion calcular() {
        if (texto.isEmpty()) {
            validacion = Validacion.VACIO;
        } else {
            try {
                int numero = Integer.parseInt(texto);
                if (numero < 1 || numero > 30) {
                    validacion = Validacion.FUERA_DE_RANGO;
                } else {
                    edadHumana = numero * 7;
                    validacion = Validacion.CORRECTO;
                }
            } catch (NumberFormatException e) {
                validacion = Validacion.NO_ES_NUMERO;
            }
        }
        return validacion;
    }
}

