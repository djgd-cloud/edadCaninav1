package es.davante.edadcanina;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int FACTOR_CANINO = 7;
    private static final int EDAD_MINIMA = 1;
    private static final int EDAD_MAXIMA = 30;

    private EditText ageEdit;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Declaramos variables
        ageEdit = findViewById(R.id.age_input);
        resultText = findViewById(R.id.result_text);
        Button button1 = findViewById(R.id.btn_calc);


        // Implementar el boton (setOnClickListener)
        button1.setOnClickListener(view -> calcularEdad());

    }
    private void calcularEdad() {

        //Leer lo que ha escrito el usuario
        String texto = ageEdit.getText().toString().trim();

        //Comprobar si está vacío
        if (texto.isEmpty()) {
            mostrarError(getString(R.string.error_vacio));
            return;
        }

        //Intentar convertir el texto en número
        int edad;

        try {
            edad = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            mostrarError(getString(R.string.error_no_numero));
            return;
        }

        //Comprobar que la edad esté entre 1 y 30
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            mostrarError(getString(
                    R.string.error_rango,
                    EDAD_MINIMA,
                    EDAD_MAXIMA
            ));
            return;
        }

        //Eliminar posibles errores anteriores
        ageEdit.setError(null);

        //Calcular la edad humana
        int edadHumana = edad * FACTOR_CANINO;

        //Mostrar el resultado
        resultText.setText(
                getString(R.string.tu_edad_format, edadHumana)
        );
    }

    private void mostrarError(String mensaje) {
        ageEdit.setError(mensaje);
        ageEdit.requestFocus();
        resultText.setText("");
    }


    }
