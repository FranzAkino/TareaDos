package sv.edu.uesocc.tareados;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

    private Intent i;
    private Button aceptar;
    private Button cancelar;
    Persona p;



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
        aceptar = (Button) findViewById(R.id.aceptar_boton);
        cancelar = (Button) findViewById(R.id.cancelar_boton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexos, android.R.layout.simple_spinner_item);

        sexo.setAdapter(adapter);


        i = this.getIntent();
        p = (Persona) i.getSerializableExtra("persona");

        nombre.setText(p.getNombre());
        apellido.setText(p.getApellido());
        edad.setText(String.valueOf(p.getEdad()));
        dui.setText(p.getDui());
        email.setText(p.getEmail());
        sexo.setSelection(sexInt(p.getSexo()));

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLleno(apellido))
                    p.setApellido(apellido.getText().toString());
                if(checkLleno(nombre))
                    p.setNombre(nombre.getText().toString());
                if(checkLleno(dui))
                    p.setDui(dui.getText().toString());
                if(checkLleno(edad))
                    p.setEdad(Integer.valueOf(edad.getText().toString()));
                if(checkLleno(email))
                    p.setEmail(email.getText().toString());
                p.setSexo(sexo.getSelectedItem().toString());


                Intent intent = new Intent();
                intent.putExtra("persona",p);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private int sexInt(String sexo){
        if(sexo.equalsIgnoreCase("Femenino"))
            return 0;
        return 1;
    }

    private boolean checkLleno(EditText ed){
        if(ed.getText().toString().isEmpty())
            return false;
        return true;
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