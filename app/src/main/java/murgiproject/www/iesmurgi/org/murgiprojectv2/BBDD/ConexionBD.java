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
    protected void onPostExecute(ResultSet resultSet) {
       try {
           int cont = 0;
           while (resultSet.next()) {
               Usuarios aux = new Usuarios(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
               Citas.users.add(aux);
               cont++;
           }
           if (cont == 0) {
               progressdialog.dismiss();
               Toast.makeText(activity, "No hay datos", Toast.LENGTH_SHORT).show();
           }
           progressdialog.dismiss();
       }catch (Exception ex){
           progressdialog.dismiss();
       }
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        ID=strings[0];
        try {
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            String rutaINI="";
            rutaINI="www.iesmurgi.org";

            conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+rutaINI+"/base20172", "ubase20172", "pbase20172");
            Statement estado = (Statement) conn.createStatement();
            String peticion = "select * from "+strings[0]+" order by apellidos";
            ResultSet result = estado.executeQuery(peticion);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}