import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Abstaccion del concepto de Persona
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Persona
{
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy = fechaHoy.get(Calendar.YEAR);
   
    private int nroDni;
    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento;
    /**
     * Constructor que establece los valores de los atributos (nroDni, nombre, apellido y
     * anioNacimiento) de los objetos instanciados en la clase "persona".
     * 
     */
        public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio){
            this.setDNI(p_dni);
            this.setNombre(p_nombre);
            this.setApellido(p_apellido);
            this.setAnioNacimiento(p_anio);
        }
    
        public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha){
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }
    /**
     * Getters y setters
     */
    private void setDNI(int p_dni){
         this.nroDni = p_dni;
     }
     
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    
    private void setAnioNacimiento(int p_anio){
        Calendar fecha = new GregorianCalendar();
        fecha.set(Calendar.YEAR, p_anio);
        this.fechaNacimiento = fecha;
    }
    
    private void setFechaNacimiento(Calendar p_fecha){
        this.fechaNacimiento = p_fecha;
    }
    
    public int getDNI(){
        return this.nroDni;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public int getAnioNacimiento(){
        return this.fechaNacimiento.get(Calendar.YEAR);
    }
    
    public Calendar getFechaNacimiento(){
        return this.fechaNacimiento;
        }
    
    /**
     * Implementacion de los metodos edad y mostrar, junto con nomYape y apeYnom para la correcta
     * impresion de los datos solicitados.
     */
     
    public int edad(){
        return anioHoy - getAnioNacimiento();
        }

    public String nomYApe(){
        return getNombre() + "," + " " + getApellido();
        
        }
    
     public String apeYNom(){
        return getApellido() + ", " + getNombre();
        
    }
    
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("DNI: " +  getDNI() + " " + "Edad: " + edad() + " " + "años");
    }
    /**
     * Define si es el dia del cumpleaños comparando el atributo Calendar de fechaNacimiento con la fecha actual. 
     * 
     * return:  Devuelve un valor booleano true o false
     * 
     */
    public boolean esCumpleaños(){
        Calendar fechaHoy = new GregorianCalendar();
  
        if(fechaHoy.get(Calendar.DAY_OF_MONTH) == getFechaNacimiento().get(Calendar.DAY_OF_MONTH) 
        && fechaHoy.get(Calendar.MONTH) == getFechaNacimiento().get(Calendar.MONTH)){
                return true;
                } else {
                return false;
            }
        }
        
}