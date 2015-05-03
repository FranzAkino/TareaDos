package sv.edu.uesocc.tareados;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    private Persona[] listaPersonas = new Persona[]{
            new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"),
            new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"),
            new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"),
            new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"),
            new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino")
    };

    private ListView lstViewPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        final AdaptadorPersona adp = new AdaptadorPersona(this, listaPersonas);

        lstViewPersonas = (ListView) findViewById(R.id.lista_personas);

        lstViewPersonas.setAdapter(adp);

        lstViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Persona persona = (Persona) adp.getItem(i);
            }
        });
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


    class AdaptadorPersona extends ArrayAdapter<Persona>{

        Activity context;

        public AdaptadorPersona(Context context,
                                 Persona[] datos) {
            super(context, R.layout.item_persona, datos);
        }

        public View getView (int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item_persona, null);


            TextView viewNombre = (TextView) item.findViewById(R.id.nombre_text);
            TextView viewApellido=(TextView) item.findViewById(R.id.apellido_text);
            TextView viewdui = (TextView) item.findViewById(R.id.dui_text);
            TextView viewEdad=(TextView) item.findViewById(R.id.edad_text);
            TextView viewSexo=(TextView) item.findViewById(R.id.sexo_text);
            TextView viewemail=(TextView) item.findViewById(R.id.email_text);


            viewNombre.setText(listaPersonas[position].getNombre());
            viewApellido.setText(listaPersonas[position].getApellido());
            viewdui.setText(listaPersonas[position].getDui());
            viewEdad.setText(Integer.toString(listaPersonas[position].getEdad()));
            viewSexo.setText(listaPersonas[position].getSexo());
            viewemail.setText(listaPersonas[position].getEmail());

            return item;
        }
    }
/*
    private class PersonaHolder {
        TextView viewNombre;
        TextView viewApellido;
        TextView viewdui;
        TextView viewemail;
        TextView viewEdad;
        TextView viewSexo;
        ImageView viewFoto;
    }*/
}
