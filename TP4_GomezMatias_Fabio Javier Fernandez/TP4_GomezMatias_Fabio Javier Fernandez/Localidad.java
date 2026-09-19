
/**
 *  Clase Localidad, es una abstraccion del concepto de una localidad con sus atributos especificos brindados por la consigna.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Localidad
{
    private String nombre;
    private String provincia;
     

        /**
         * Constructor de la clase Localidad
         * 
         * param: Recibe como parametros datos del mismo tipo que los atributos de los objetos de la clase para poder usar los setter para establecer la informacion..
         * return: ----
         * 
         * 
         */
    public Localidad(String p_nombre, String p_provincia) {
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }
 
    
        /**
         * Getters y Setters
         */
    public String getNombre() {
        return this.nombre;
    }
 
    public void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
 
    public String getProvincia() {
        return this.provincia;
    }
 
    public void setProvincia(String p_provincia) {
        this.provincia = p_provincia;
    }
     
        /**
         * Imprime en un string los datos de nombre de la localidad y la provincia a la cual pertenece
         * 
         * param: ----
         * return: String.
         * 
         * 
         */
    public String mostrar() {
        
        return "Localidad: " + this.getNombre() + " " + "Provincia: " + this.getProvincia();
    }

}