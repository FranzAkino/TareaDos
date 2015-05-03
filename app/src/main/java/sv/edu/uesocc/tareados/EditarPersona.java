package sv.edu.uesocc.tareados;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class EditarPersona extends ActionBarActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private EditText dui;
    private EditText email;
    private Spinner sexo;
    private String[] sexoList = new String[]{"m","f"};

    private Button aceptar;
    private Button Cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        nombre = (EditText) findViewById(R.id.nombre_edit);
        apellido = (EditText) findViewById(R.id.apellido_edit);
        edad = (EditText) findViewById(R.id.edad_edit);
        dui = (EditText) findViewById(R.id.dui_edit);
        email = (EditText) findViewById(R.id.correo_edit);
        sexo = (Spinner) findViewById(R.id.sexo_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexos, android.R.layout.simple_spinner_item);

        sexo.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_editar_persona, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}