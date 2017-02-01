package murgiproject.www.iesmurgi.org.murgiprojectv2;

/**
 * Created by usuario on 31/01/17.
 */

public class Cursos {


    private String titulo , descripcion ;
    private int imagen;


    public Cursos(String titulo, String descripcion, int imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;

        this.imagen = imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
