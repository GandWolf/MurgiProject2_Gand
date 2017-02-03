package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);


        LinearLayout iesmurgi = (LinearLayout)findViewById(R.id.ir_iesMurgi);
        LinearLayout contacto = (LinearLayout)findViewById(R.id.boton_contacto);
        LinearLayout matriculacion = (LinearLayout)findViewById(R.id.boton_matriculacion);
        LinearLayout mapa= (LinearLayout)findViewById(R.id.boton_mapa);
        LinearLayout curso= (LinearLayout)findViewById(R.id.boton_cursos);
        LinearLayout citas= (LinearLayout)findViewById(R.id.boton_cita);




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
//        murgi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               Intent intent = new Intent(getApplicationContext(), Historia.class);
//               startActivity(intent);
//            }
//        });

        iesmurgi.setOnClickListener(new View.OnClickListener() {
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
