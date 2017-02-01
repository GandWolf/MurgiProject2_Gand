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

        cursos=new ArrayList<>();
        if(pos==1){
            cursos.add(new Cursos("Bachillerato a","descripcion de bachillertato", R.drawable.bachillerato));
            cursos.add(new Cursos("Bachillerato b","descripcion de bachillertato", R.drawable.bachillerato));
        }


        adapter = new VerCursosAdapter(this, cursos);
        listView = (ListView) findViewById(R.id.mListView);
        listView.setAdapter(adapter);


    }
}
