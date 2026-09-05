
/**
 *  Clase Paciente, es una abstraccion del concepto de un paciente con sus atributos especificos brindados por la consigna.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Paciente
{
    private int historiaClinica;
    private String nombre;
    private String domicilio;
    private Localidad localidadNacido;
    private Localidad localidadVive;
         /**
         * Constructor de la clase Paciente
         * 
         * param: Recibe como parametros datos del mismo tipo que los atributos de los objetos de la clase para poder usar los setter para establecer la informacion..
         * return: ----
         * 
         * 
         */
    public Paciente(int p_historia, String p_nombre, String p_domicilio,
                     Localidad p_localidadNacido, Localidad p_localidadVive) {
        this.setHistoriaClinica(p_historia);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setLocalidadNacido(p_localidadNacido);
        this.setLocalidadVive(p_localidadVive);
    }
          /**
         * Getters y Setters
         */
    public int getHistoriaClinica() {
        return this.historiaClinica;
    }
 
    private void setHistoriaClinica(int p_historia) {
        this.historiaClinica = p_historia;
    }
 
    public String getNombre() {
        return this.nombre;
    }
 
    private void setNombre(String  p_nombre) {
        this.nombre =  p_nombre;
    }
 
    public String getDomicilio() {
        return this.domicilio;
    }
 
    private void setDomicilio(String p_domicilio) {
        this.domicilio = p_domicilio;
    }
 
    private void setLocalidadNacido(Localidad p_localidadNacido) {
        this.localidadNacido = p_localidadNacido;
    }
 
    public Localidad getLocalidadNacido() {
        return this.localidadNacido;
        }
 
    public void setLocalidadVive(Localidad p_localidadVive) {
        this.localidadVive = p_localidadVive;
    }
 
    public Localidad getLocalidadVive() {
        return this.localidadVive;
    }
     
    
         /**
         * Imprime en el formato solicitado la informacion del paciente y sus dos localidades
         * 
         * param: ----
         * return: void.
         * 
         * 
         */
    public void mostrarDatosPantalla() {
        System.out.println("Paciente: " + this.getNombre() + " " + "Historia Clinica: " + this.getHistoriaClinica() + " " + "Domicilio: " + getDomicilio());
        System.out.println("Localidad donde vive: ");
        System.out.println(getLocalidadVive().mostrar());
        System.out.println("Localidad donde nacio: ");
        System.out.println(this.getLocalidadNacido().mostrar());
    }
     
    
    /**
         * Imprime en el formato lineal solicitado la informacion del paciente y su localidad donde vive
         * 
         * param: ----
         * return: String concatenando toda la informacion del paciente y su localidad.
         * 
         * 
         */
    public String cadenaDeDatos() {
        return this.getNombre() + "......." + this.getHistoriaClinica() + "......." + this.getDomicilio() + " - " + this.getLocalidadVive().getNombre() + " - " + 
        this.getLocalidadVive().getProvincia();
    }

}