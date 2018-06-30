package thefinalproyect;
/**
 *
 * @author Ricardo Sanchez
 */
public class Campos {
    String Tipo;
    String Nombre;

    public Campos() {
    }

    public Campos(String Tipo, String Nombre) {
        this.Tipo = Tipo;
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return Tipo + "|" + Nombre+";" ;
    }
    
}
