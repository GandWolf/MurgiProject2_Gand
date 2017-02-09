package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InsertarDatos extends AsyncTask<String, Void, Statement> {

    Activity activity;
    private String nombre, apellidos, asunto;
    private String fecha, hora;

    public InsertarDatos(Activity activity, String nombre, String apellidos, String asunto, String fecha, String hora) {
        this.activity = activity;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.asunto = asunto;
        this.fecha = fecha;
        this.hora = hora;

    }


    @Override
    protected Statement doInBackground(String... params) {
        try {
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            String rutaINI = "";
            rutaINI = "www.iesmurgi.org";

            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + rutaINI + "/base20172", "ubase20172", "pbase20172");
            Statement estado = (Statement) conn.createStatement();

            insertUser(estado);
            insertFecha(estado);
            insertHora(estado);


            return estado;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(Statement statement) throws SQLException {
        String insert = "insert into usuarios (nombre,apellidos,asunto)values('" + nombre + "','" + apellidos + "','" + asunto + "')";
        statement.executeUpdate(insert);
    }

    public void insertFecha(Statement statement) throws SQLException {

        String insert = "insert into fecha (fecha) values('" + fecha + "')";
        statement.executeUpdate(insert);
    }

    public void insertHora(Statement statement) throws SQLException {

        String insert = "insert into hora(hora) values('" + hora + "')";
        statement.executeUpdate(insert);
    }




}
