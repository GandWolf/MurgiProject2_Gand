package murgiproject.www.iesmurgi.org.murgiprojectv2.BBDD;

import java.io.Serializable;


public class Usuarios implements Serializable{


    private String id, nombre,apellidos, asunto;


    public Usuarios(String id, String nombre, String apellidos, String asunto) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.asunto = asunto;
    }


    public String getID() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getAsunto() {
        return asunto;
    }


}
