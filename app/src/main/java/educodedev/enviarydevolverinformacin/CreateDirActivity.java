package educodedev.enviarydevolverinformacin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import educodedev.enviarydevolverinformacin.modelos.Direccion;

public class CreateDirActivity extends AppCompatActivity {
        private EditText txtCalle, txtNumero, txtCiudad;
        private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dir);
inicializarVistas();

btnCrear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String calle = txtCalle.getText().toString();
        int numero = Integer.parseInt(txtNumero.getText().toString());
        String ciudad = txtCiudad.getText().toString();

        Direccion direccion = new Direccion(calle, numero, ciudad);


        // 2. ENVIAR DESDE LA SEGUNDA A LA PRIMERA
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DIR", direccion);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();


    }
});
    }

    private void inicializarVistas() {
        txtCalle = findViewById(R.id.txtCalleCreateDir);
        txtNumero = findViewById(R.id.txtNumeroCreateDir);
        txtCiudad = findViewById(R.id.txtCiudadCreateDir);
        btnCrear =findViewById(R.id.btnCreatCreateDir);

    }
}