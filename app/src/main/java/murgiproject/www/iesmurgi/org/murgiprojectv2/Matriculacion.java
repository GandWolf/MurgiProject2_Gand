package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Matriculacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriculacion);

        TextView link = (TextView)findViewById(R.id.link1);
        TextView link2 = (TextView)findViewById(R.id.link3);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        link2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
