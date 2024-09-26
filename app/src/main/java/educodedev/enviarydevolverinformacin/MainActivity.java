package educodedev.enviarydevolverinformacin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import educodedev.enviarydevolverinformacin.modelos.Direccion;
import educodedev.enviarydevolverinformacin.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText  txtEmail,txtPassword;
    private Button btnEnviar, btnCrearDir;
    private final int DIRECCIONES = 123;
    private ActivityResultLauncher<Intent> launcherDirecciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();
        inicializarLaunchers();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                Usuario usuario = new Usuario(email,password);
                Intent intent = new Intent(MainActivity.this, DesencriptarActivity.class);
                Bundle bundle = new Bundle(); //Para meter valores y meterlos en otra actividad
                bundle.putSerializable("USER", usuario);
                intent.putExtras(bundle); // meter mis valores en el intent
                startActivity(intent);
            }
        });

        btnCrearDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateDirActivity.class);
              //  startActivityForResult(intent,DIRECCIONES);
            launcherDirecciones.launch(intent);




            }
        });
    }

    private void inicializarLaunchers() {
        
        launcherDirecciones = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK){

                    if (o.getData()!=null){

                        Bundle bundle = o.getData().getExtras();
                        Direccion dir = (Direccion) bundle.getSerializable("DIR");
                        Toast.makeText(MainActivity.this, dir.toString(), Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();

                }


            }
        });
        
    }

    private void inicializarVistas() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnEnviar = findViewById(R.id.bntEnviarMain);
        btnCrearDir = findViewById(R.id.btnCrearDirMain);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == DIRECCIONES){

            if (resultCode == RESULT_OK){

                if (data!=null){

                    Bundle bundle = data.getExtras();
                    Direccion dir = (Direccion) bundle.getSerializable("DIR");
                    Toast.makeText(this, dir.toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();

                }
            }else{
                Toast.makeText(this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();

            }

        }

    }
}