package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static murgiproject.www.iesmurgi.org.murgiprojectv2.Citas.datosFecha;
import static murgiproject.www.iesmurgi.org.murgiprojectv2.Citas.datosHora;



public class ConexionBD extends AsyncTask<String, Void, ResultSet> {


    Activity activity;

    public ConexionBD(Activity activity) {
        this.activity=activity;
    }

    @Override
    protected void onPostExecute(ResultSet result) {
        try {
            if (result != null){
                if (!result.next()) {
                    Toast toast = Toast.makeText(activity,"No existen resultados con ese nombre",Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    datosHora.clear();
                    datosFecha.clear();
                   //consulta hora y fecha y almacenar en arraylist datosHora y datosFecha
                    while(result.next()){
                        datosHora.add(result.getString(1));
                        datosFecha.add(result.getString(2));
                    }
                }
            }else{
                Toast toast = Toast.makeText(activity,"Consulta no disponible",Toast.LENGTH_LONG);
                toast.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    @Override
    protected ResultSet doInBackground(String... strings) {

        try {
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            String rutaINI="www.iesmurgi.org";

            conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+rutaINI+"/base20172", "ubase20172", "pbase20172");
            Statement estado = (Statement) conn.createStatement();
            String peticion = "SELECT hora, fecha from hora , fecha where id_fecha = id_hora";
            ResultSet result = estado.executeQuery(peticion);
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}