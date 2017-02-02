package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class VerCursos extends AppCompatActivity {
    FloatingActionButton fab_atras;
    VerCursosAdapter adapter;
    ListView listView;
    ArrayList<Cursos> cursos;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_list);

        fab_atras=(FloatingActionButton)findViewById(R.id.fab);
        fab_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividadCursos = new Intent(VerCursos.this, MainActivity.class);
                startActivity(actividadCursos);
            }
        });

        //nposicion de categoria
        Intent i = getIntent();
        Bundle b = i.getExtras();
        pos = b.getInt("pos");


        if(pos==1){
            cursos=new ArrayList<>();
            cursos.add(new Cursos("BACHILLERATO EN CIENCIAS Y TECNOLOGÍA ","descripcion ", R.drawable.bachillerato));
            cursos.add(new Cursos("BACHILLERATO EN HUMANIDADES Y CIENCIAS SOCIALES","descripcion ", R.drawable.bachillerato));
            cursos.add(new Cursos("BACHILLERATO EN ARTES ","descripcion", R.drawable.bachillerato));
        }

        if(pos==2){
            cursos=new ArrayList<>();
            cursos.add(new Cursos("Mantenimiento de vehículos"," Realizar operaciones básicas de mantenimiento electromecánico y carrocería de vehículos, desmontando y montando elementos",R.drawable.mecanica_motor));
        }

        if(pos==3){
            cursos=new ArrayList<>();
            cursos.add(new Cursos("Sistemas Microinformáticos y redes (SMR)","Instalar, configurar y mantener sistemas microinformáticos, aislados o en red, así como redes locales en pequeños entornos." ,R.drawable.fp_medio));
            cursos.add(new Cursos("Gestión administrativa (GAD) ","Realizar actividades de apoyo administrativo en el ámbito laboral, contable, comercial, financiero y fiscal, así como de atención al cliente/usuario, tanto en empresas públicas como privadas, aplicando la normativa vigente y protocolos de calidad, asegurando la satisfacción del cliente y actuando según normas de prevención de riesgos laborales y protección ambiental." ,R.drawable.fp_medio));
            cursos.add(new Cursos("Instalaciones Eléctricas y Automáticas (IEA) ","Montar y mantener infraestructuras de telecomunicación en edificios, instalaciones eléctricas de baja tensión, máquinas eléctricas y sistemas automatizados." ,R.drawable.fp_medio));
            cursos.add(new Cursos("Electromecánica de Vehículos Automóviles ","Proporciona los conocimientos necesarios para efectuar operaciones de mantenimiento, montaje de accesorios y transformaciones del vehículo en las áreas de mecánica, hidráulica, neumática y electricidad, además de ajustarse a los procedimientos y tiempos determinados, consiguiendo la calidad requerida y cumpliendo las condiciones de seguridad establecidas." , R.drawable.mecanica_motor));
        }

        if(pos==4) {
            cursos = new ArrayList<>();
            cursos.add(new Cursos("Desarrollo de Aplicaciones Multiplataforma","Desarrollando aplicaciones informáticas para la gestión empresarial y de negocio. Desarrollando aplicaciones de propósito general. Desarrollando aplicaciones en el ámbito del entretenimiento y la informática móvil.",R.drawable.fp_superior));
            cursos.add(new Cursos("Administración y Finanzas", " Este profesional ejerce su actividad tanto en grandes como en medianas y pequeñas empresas, en cualquier sector de actividad, y particularmente en el sector servicios, así como en las administraciones públicas, desempeñando las tareas administrativas en la gestión y el asesoramiento en las áreas laboral, comercial, contable y fiscal de dichas empresas e instituciones, ofreciendo un servicio y atención a los clientes y ciudadanos, realizando trámites administrativos con las administraciones públicas y gestionando el archivo y las comunicaciones de la empresa. " , R.drawable.fp_superior));
        }



        adapter = new VerCursosAdapter(this, cursos);
        listView = (ListView) findViewById(R.id.mListView);
        listView.setAdapter(adapter);


    }
}
