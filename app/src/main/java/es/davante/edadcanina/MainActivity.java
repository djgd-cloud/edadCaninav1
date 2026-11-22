package es.davante.edadcanina;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import es.davante.edadcanina.databinding.ActivityMainBinding;
import es.davante.edadcanina.modelo.EdadCaninaModelo;
import es.davante.edadcanina.modelo.Validacion;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EdadCaninaModelo modelo = new EdadCaninaModelo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnCalc.setOnClickListener(view -> {
            modelo.setTexto(binding.ageInput.getText().toString());
            Validacion resultado = modelo.calcular();

            switch (resultado) {
                case CORRECTO:
                    binding.resultText.setText(getString(R.string.tu_edad_format, modelo.getEdadHumana()));
                    break;
                case VACIO:
                    binding.ageInput.setError("Introduce una edad");
                    break;
                case NO_ES_NUMERO:
                    binding.ageInput.setError("Introduce un número");
                    break;
                case FUERA_DE_RANGO:
                    binding.ageInput.setError("Fuera de rango");
                    break;
                default:
                    break;
            }
        });

    }
}