package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ExpandableListActivity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import murgiproject.www.iesmurgi.org.murgiprojectv2.Citas;


public class ConexionBD extends AsyncTask<String, Void, ResultSet> {

    String ID;
    Activity activity;
    AlertDialog progressdialog;

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

                    Toast toast = Toast.makeText(activity,result.getString("apellidos"),Toast.LENGTH_LONG);
                    toast.show();
                }
            }else{
                Toast toast = Toast.makeText(activity,"consulta no está",Toast.LENGTH_LONG);
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
            String rutaINI="";
            rutaINI="www.iesmurgi.org";

            conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+rutaINI+"/base20172", "ubase20172", "pbase20172");
            Statement estado = (Statement) conn.createStatement();
            String peticion = "select * from "+strings[0]+" where id_user='2'";
            ResultSet result = estado.executeQuery(peticion);
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}