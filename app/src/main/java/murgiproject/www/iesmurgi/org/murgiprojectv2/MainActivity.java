package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


        ImageButton murgi = (ImageButton)findViewById(R.id.boton_ies_murgi);
        ImageButton contacto = (ImageButton)findViewById(R.id.boton_contacto);
        ImageButton matriculacion = (ImageButton)findViewById(R.id.boton_matriculacion);
        ImageButton mapa= (ImageButton)findViewById(R.id.boton_mapa);
        ImageButton curso= (ImageButton)findViewById(R.id.boton_cursos);
        ImageButton citas= (ImageButton)findViewById(R.id.boton_cita);



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        //Temporal
        TextView titulo_splash= (TextView)findViewById(R.id.textoInicio);
        Typeface face= Typeface.createFromAsset(getAssets(),"font/letra.TTF"); //Llamamos a la fuente no incluida en Android
        titulo_splash.setTypeface(face);
        murgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), Historia.class);
               startActivity(intent);
            }
        });

        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Contacto.class);
                startActivity(intent);
            }
        });

        matriculacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Matriculacion.class);
                startActivity(intent);
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity2.class);
                startActivity(intent);
            }
        });

     curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VerCategoriasCursos.class);
                startActivity(intent);
            }
        });

        citas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Citas.class);
                startActivity(intent);
            }
        });
    }
}
