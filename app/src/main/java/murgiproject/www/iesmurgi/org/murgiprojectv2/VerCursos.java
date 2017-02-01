package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class VerCursos extends AppCompatActivity {
    VerCursosAdapter adapter;
    ListView listView;
    ArrayList<Cursos> cursos;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_list);

        //nposicion de categoria
        Intent i = getIntent();
        Bundle b = i.getExtras();
        pos = b.getInt("pos");


        if(pos==1){
            cursos=new ArrayList<>();
            cursos.add(new Cursos("BACHILLERATO EN CIENCIAS Y TECNOLOGÍA ","descripcion de bachillertato", R.drawable.bachillerato));
            cursos.add(new Cursos("BACHILLERATO EN HUMANIDADES Y CIENCIAS SOCIALES","descripcion de bachillertato", R.drawable.bachillerato));
            cursos.add(new Cursos("BACHILLERATO EN ARTES ","descripcion de bachillertato", R.drawable.bachillerato));
        }

        if(pos==2){
            cursos=new ArrayList<>();
            cursos.add(new Cursos("EL","",R.drawable.fp_basica));
        }







        adapter = new VerCursosAdapter(this, cursos);
        listView = (ListView) findViewById(R.id.mListView);
        listView.setAdapter(adapter);


    }
}
