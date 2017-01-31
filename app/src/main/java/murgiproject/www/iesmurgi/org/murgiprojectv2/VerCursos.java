package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VerCursos extends AppCompatActivity {

    ImageButton btn_bachiller, btn_fpBasica, btn_fpMedio, btn_fpSuperior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cursos);

        btn_bachiller=(ImageButton)findViewById(R.id.btn_irBachillerato);



    }
}
