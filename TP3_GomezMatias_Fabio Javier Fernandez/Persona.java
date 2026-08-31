import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Write a description of class persona here.
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
    private int anioNacimiento;
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
    
    private void setDNI(int p_dni){
         nroDni = p_dni;
     }
     
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    
    private void setApellido(String p_apellido){
        apellido = p_apellido;
    }
    
    private void setAnioNacimiento(int p_anio){
        anioNacimiento = p_anio;
    }
    
    public int getDNI(){
        return nroDni;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public int getAnioNacimiento(){
        return anioNacimiento;
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
        return getApellido() + "," + getNombre();
        
    }
    
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("DNI: " +  getDNI() + " " + "Edad: " + edad() + " " + "años");
    }
    
}