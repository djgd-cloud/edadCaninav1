package es.davante.edadcanina.vista;

import android.content.Context;
import android.widget.EditText;
import androidx.databinding.BindingAdapter;
import es.davante.edadcanina.R;
import es.davante.edadcanina.modelo.Validacion;

public class AdaptadoresVista {
    @BindingAdapter("errorValidacion")
    public static void mostrarError(EditText campo, Validacion validacion) {
        Context contexto = campo.getContext();
        String mensaje;

        switch (validacion) {
            case VACIO:
                mensaje = contexto.getString(R.string.error_vacio);
                break;
            case NO_ES_NUMERO:
                mensaje = contexto.getString(R.string.error_no_numero);
                break;
            case FUERA_DE_RANGO:
                mensaje = contexto.getString(R.string.error_fuera_rango);
                break;
            default:
                mensaje = null;
        }

        campo.setError(mensaje);
        if (mensaje != null) {
            campo.requestFocus();
        }
    }
}
