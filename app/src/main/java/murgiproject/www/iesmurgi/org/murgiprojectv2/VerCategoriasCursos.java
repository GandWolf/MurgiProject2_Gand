package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VerCategoriasCursos extends AppCompatActivity {


    ImageButton btn_bachiller, btn_fpBasica, btn_fpMedio, btn_fpSuperior, btn_eoIdiomas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_categoria_cursos);


        btn_bachiller = (ImageButton) findViewById(R.id.btn_irBachillerato);
        btn_fpBasica = (ImageButton) findViewById(R.id.btn_irFpBasico);
        btn_fpMedio = (ImageButton) findViewById(R.id.btn_irGradoMedio);
        btn_fpSuperior = (ImageButton) findViewById(R.id.btn_irGradoSuperior);
        btn_eoIdiomas = (ImageButton) findViewById(R.id.btn_irEscuelaIdiomas);


        btn_bachiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(1);

            }
        });

        btn_fpBasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(2);
            }
        });


        btn_fpMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(3);
            }
        });

        btn_fpSuperior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(4);
            }
        });

        btn_eoIdiomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(5);
            }
        });


    }
    //intent que le pasa la posicion a la clase ver cursos
    public void startActivity(int pos){
        Intent i = new Intent(VerCategoriasCursos.this, VerCursos.class);
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        i.putExtras(b);
        startActivity(i);
    }
}
