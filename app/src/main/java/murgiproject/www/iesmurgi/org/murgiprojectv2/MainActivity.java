package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        ImageButton murgi = (ImageButton)findViewById(R.id.boton_ies_murgi);
        ImageButton contacto = (ImageButton)findViewById(R.id.boton_contacto);
        ImageButton matriculacion = (ImageButton)findViewById(R.id.boton_matriculacion);
        ImageButton mapa= (ImageButton)findViewById(R.id.boton_mapa);
        ImageButton curso= (ImageButton)findViewById(R.id.boton_cursos);
        ImageButton citas= (ImageButton)findViewById(R.id.boton_cita);

        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        //Temporal

        murgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getBaseContext(), Historia.class);
               startActivity(intent);
            }
        });

        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Contacto.class);
                startActivity(intent);
            }
        });

        matriculacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Matriculacion.class);
                startActivity(intent);
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MapsActivity2.class);
                startActivity(intent);
            }
        });

     curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), VerCategoriasCursos.class);
                startActivity(intent);
            }
        });

        citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Citas.class);
                startActivity(intent);
            }
        });
    }
}
