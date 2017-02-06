package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by usuario on 6/02/17.
 */

public class InsertarDatos extends AsyncTask<String, Void, Statement> {

    Activity activity;
    private String nombre, apellidos, asunto;

    public InsertarDatos(Activity activity, String nombre, String apellidos, String asunto) {
        this.activity = activity;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.asunto = asunto;
    }





    @Override
    protected Statement doInBackground(String... params) {
        try {
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            String rutaINI="";
            rutaINI="www.iesmurgi.org";

            conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+rutaINI+"/base20172", "ubase20172", "pbase20172");
            Statement estado = (Statement) conn.createStatement();

                insert(estado);
            return estado;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Statement statement) throws SQLException {

        String insert = "insert into usuarios(nombre,apellidos,asunto) values('"+nombre+"','"+apellidos+"','"+asunto+"')";
        statement.executeUpdate(insert);

    }



}
