package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VerCursos extends AppCompatActivity {

    ImageButton btn_bachiller, btn_fpBasica, btn_fpMedio, btn_fpSuperior, btn_eoIdiomas;
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cursos);

        btn_bachiller = (ImageButton) findViewById(R.id.btn_irBachillerato);
        btn_fpBasica = (ImageButton) findViewById(R.id.btn_irFpBasico);
        btn_fpMedio = (ImageButton) findViewById(R.id.btn_irGradoMedio);
        btn_fpSuperior = (ImageButton) findViewById(R.id.btn_irGradoSuperior);
        btn_eoIdiomas = (ImageButton) findViewById(R.id.btn_irEscuelaIdiomas);


        btn_bachiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos=1;
                Intent i = new Intent(VerCursos.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putInt("pos", pos);
                i.putExtras(b);
                startActivity(i);
            }
        });

        btn_fpBasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btn_fpMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_fpSuperior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_eoIdiomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
