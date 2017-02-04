package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Citas extends AppCompatActivity {

    Spinner spinner;
    TextView cabecera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView cabecera= (TextView)findViewById(R.id.cabecera);

        cabecera.setVisibility(View.INVISIBLE);

        //Crearnos una adaptador para volcar los datos

        ArrayAdapter<CharSequence> adapta= ArrayAdapter.createFromResource (this, R.array.consultas_secretaria_array, android.R.layout.simple_spinner_item);

        //Forma en la que se desplegara la lista de opciones

        adapta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Asignarlo a nuestro adaptador

        spinner.setAdapter(adapta);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        break;
                    case 1:
                        Toast.makeText(parent.getContext(),"Has seleccionado "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT ).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 2:
                        Toast.makeText(parent.getContext(),"Has seleccionado "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT ).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 3:
                        Toast.makeText(parent.getContext(),"Has seleccionado "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT ).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 4:
                        Toast.makeText(parent.getContext(),"Has seleccionado "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT ).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;

                    case 5:
                        Toast.makeText(parent.getContext(),"Has seleccionado "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT ).show();
                        cabecera.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
