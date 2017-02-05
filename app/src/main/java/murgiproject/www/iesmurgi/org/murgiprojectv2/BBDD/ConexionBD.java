package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

import android.os.AsyncTask;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ConexionBD extends AsyncTask<String, Void, ResultSet> {

    String ID;

    public ConexionBD() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
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