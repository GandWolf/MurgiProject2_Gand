package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VerCursosAdapter extends ArrayAdapter<Cursos> {


    ArrayList<Cursos> cursos;

    VerCursosAdapter(Activity context, ArrayList<Cursos> cur) {
        super(context, 0, cur);
        this.cursos = cur;
    }

    @NonNull
    @Override
    public View getView(int i, View vista, ViewGroup vistagrupo) {


        if (vista == null) {
            Context cnt = vistagrupo.getContext();
            vista = LayoutInflater.from(cnt).inflate(R.layout.esqueleto_ver_cursos, null);
        }


        final Cursos mCurso = cursos.get(i);
        TextView titulo = (TextView) vista.findViewById(R.id.tv_titulo);
        TextView descripcion = (TextView) vista.findViewById(R.id.tv_descripcion);
        ImageView imagen = (ImageView) vista.findViewById(R.id.iv_portada);


        titulo.setText(mCurso.getTitulo());
        descripcion.setText(mCurso.getDescripcion());
        imagen.setImageResource(mCurso.getImagen());

        return vista;

    }


}
