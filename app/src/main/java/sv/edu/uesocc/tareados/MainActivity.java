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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    private ArrayList<Persona> listaPersonas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPersonas.add(new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"));
        listaPersonas.add(new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"));
        listaPersonas.add(new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"));
        listaPersonas.add(new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"));
        listaPersonas.add(new Persona("Yanci","Nerio","1234124","asdf@asdf.net",3,"femenino"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        Context context;
        int layoutResourceId;
        Persona data[]= null;

        public AdaptadorPersona(Context context,
                                 int layoutResourceId, Persona[] data) {
            super(context, layoutResourceId, data);
            this.context = context;
            this.layoutResourceId = layoutResourceId;
            this.data = data;
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            View row = convertView;
            PersonaHolder holder = null;
            Persona persona = data[position];

            if(row==null){
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new PersonaHolder();
                holder.viewNombre = (TextView) row.findViewById(R.id.nombre_text);
                holder.viewApellido=(TextView) row.findViewById(R.id.apellido_text);
                holder.viewEdad=(TextView) row.findViewById(R.id.edad_text);
                holder.viewSexo=(TextView) row.findViewById(R.id.sexo_text);
                holder.viewemail=(TextView) row.findViewById(R.id.email_text);


            }



            holder.viewNombre.setText(persona.getNombre());
            holder.viewApellido.setText(persona.getApellido());
            holder.viewdui.setText(persona.getDui());
            holder.viewEdad.setText(persona.getEdad());
            holder.viewSexo.setText(persona.getSexo());
            holder.viewemail.setText(persona.getEmail());


            //holder.viewFoto.setImageResource();

            return row;
        }



    }

    private class PersonaHolder {
        TextView viewNombre;
        TextView viewApellido;
        TextView viewdui;
        TextView viewemail;
        TextView viewEdad;
        TextView viewSexo;
        ImageView viewFoto;
    }
}
