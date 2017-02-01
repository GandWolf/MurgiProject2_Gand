package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000; //Definimos la duración del Splash

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run (){
                Intent homeIntent= new Intent(SplashActivity.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT); //Tras la duración definida, irá desde esta clase "MainActivity" hacia la clase "JuegosVer", definido a través del Intent

        TextView titulo_splash= (TextView)findViewById(R.id.textView_titulo_splash);
        Typeface face= Typeface.createFromAsset(getAssets(),"font/letra.TTF"); //Llamamos a la fuente no incluida en Android
        titulo_splash.setTypeface(face);
    }
}
