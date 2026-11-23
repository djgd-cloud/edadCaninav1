package es.davante.edadcanina.modelo;

import androidx.databinding.Bindable;
import androidx.databinding.BaseObservable;
import es.davante.edadcanina.BR;


public class EdadCaninaModelo extends BaseObservable {
    private String texto = "";
    private int edadHumana;
    private Validacion validacion = Validacion.SIN_CALCULAR;

    @Bindable
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        if (this.texto.equals(texto)) return;

        this.texto = texto;
        notifyPropertyChanged(BR.texto);

        setValidacion(Validacion.SIN_CALCULAR);
    }

    @Bindable
    public int getEdadHumana() {
        return edadHumana;
    }

    private void setEdadHumana(int edadHumana) {
        this.edadHumana = edadHumana;
        notifyPropertyChanged(BR.edadHumana);
    }

    @Bindable
    public Validacion getValidacion() {
        return validacion;
    }

    private void setValidacion(Validacion validacion) {
        this.validacion = validacion;
        notifyPropertyChanged(BR.validacion);
    }

    public Validacion calcular() {
        if (texto.isEmpty()) {
            setValidacion(Validacion.VACIO);
        } else {
            try {
                int numero = Integer.parseInt(texto);
                if (numero < 1 || numero > 30) {
                    setValidacion(Validacion.FUERA_DE_RANGO);
                } else {
                    setEdadHumana(numero * 7);
                    setValidacion(Validacion.CORRECTO);
                }
            } catch (NumberFormatException e) {
                setValidacion(Validacion.NO_ES_NUMERO);
            }
        }
        return validacion;
    }
}