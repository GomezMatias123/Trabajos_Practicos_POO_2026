
/**
 *  Clase Hospital, es una abstraccion del concepto hospital con sus atributos especificos brindados por la consigna y nos va a permitir manipular su atributos paciente que representa un objeto 
 *  de la clase  Paciente.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Hospital
{
    private String nombreHospital;
    private String nombreDirector;
 
        /**
         * Constructor de la clase Hospital.
         * 
         * param: Recibe como parametros datos del mismo tipo que los atributos nombreHospital y nombreDirector para poder usar los setter para establecer la informacion.
         * return: ----.
         * 
         * 
         */
    public Hospital(String p_nombre, String p_director) {
        this.setNombreHospital(p_nombre);
        this.setNombreDirector(p_director);
    }
    
         /**
         * Getter y Setters
         * 
         */
    public String getNombreHospital() {
        return this.nombreHospital;
    }
 
    private void setNombreHospital(String p_nombre) {
        this.nombreHospital = p_nombre;
    }
 
    public String getNombreDirector() {
        return this.nombreDirector;
    }
 
    private void setNombreDirector(String p_director) {
        this.nombreDirector = p_director;
    }
    
        /**
         * Imprime en el formato solicitado la informacion del hospital junto con la del paciente y sus dos localidades, conoce al objeto de Clase Paciente mediante parametro.
         * 
         * param: Recibe como parametros un objeto de clase Paciente
         * return: Impresion de los datos por pantalla
         * 
         * 
         */
 
    public void consultaDatosFiliatorios(Paciente p_paciente) {
        System.out.println("Hospital: " + this.getNombreHospital() + " " + "Director: " + this.getNombreDirector());
        System.out.println("--------------------------------------------------------------------------------------");
        p_paciente.mostrarDatosPantalla();
    }

}