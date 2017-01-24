package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by usuario on 23/01/17.
 */

public class Contacto extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        Typeface letramurgi = Typeface.createFromAsset(getAssets(), "font/letra.TTF");

        TextView murgi = (TextView) findViewById(R.id.txt_murgi);
        murgi.setTypeface(letramurgi);
    }
}
