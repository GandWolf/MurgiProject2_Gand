package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
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


     //mostrar datos





        return vista;

    }


}
