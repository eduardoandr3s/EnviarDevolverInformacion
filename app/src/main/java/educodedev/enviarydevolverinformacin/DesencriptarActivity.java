package educodedev.enviarydevolverinformacin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import educodedev.enviarydevolverinformacin.modelos.Usuario;

public class DesencriptarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){

            Usuario usuario = (Usuario) bundle.getSerializable("USER");
            Toast.makeText(this, usuario.toString(), Toast.LENGTH_SHORT).show();

        }

    }
}