package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Matriculacion extends AppCompatActivity {
    ImageView linkSecretaria;
    ImageView linkInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriculacion);


        linkInfo = (ImageView)findViewById(R.id.masInfo);
        linkInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.juntadeandalucia.es/temas/estudiar/fp/matriculacion.html"));
                startActivity(i);
            }
        });

        linkSecretaria =(ImageView)findViewById(R.id.img_secretariaVitual);
        linkSecretaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.juntadeandalucia.es/educacion/secretariavirtual/"));
                startActivity(i);
            }
        });

    }
}
