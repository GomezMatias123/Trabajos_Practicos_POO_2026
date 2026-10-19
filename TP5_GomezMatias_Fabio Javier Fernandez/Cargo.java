import java.util.*;
import java.util.Scanner;
/**
 * Es una abstaraccion de un cargo simple
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Cargo
{
    
    //atributos
    
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    protected int horasDeDocencia;
    
    /**
     * 
     * Es un contructor de la clase cargo
     */
    
    public Cargo(String p_nombre, double p_sueldo, int p_anio, int p_horas) {
        
        this.setNombreCargo(p_nombre);
        this.setSueldoBasico(p_sueldo);
        this.setAnioIngreso(p_anio);
        
        Scanner teclado = new Scanner(System.in);
        this.setHorasDeDocencia(p_horas, teclado);
        
    }
    
    /**
     * 
     * retorna la antiguedad de un profesor en un cargo simple
     * 
     */
    
    
    public int antiguedad() {
        
        Calendar fechaHoy = new GregorianCalendar();
        
        return fechaHoy.get(Calendar.YEAR) - this.getAnioIngreso();
        
    }
    
    /**
     * 
     * retorna el adicional por antiguedad
     * 
     */
    
    private double adicionalXAntiguedad() {
        
        return (this.getSueldoBasico() * (this.antiguedad() * 0.010));
        
    }
    
    /**
     * 
     * retorna un valor que representa el sueldo
     * 
     */
    
    public double sueldoDelCargo() {
        
        return this.getSueldoBasico() + this.adicionalXAntiguedad();
        
    }
    
    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     */
    
    public void mostrarCargo() {
        
        System.out.println(this.getNombreCargo() + " - Sueldo Basico: " + this.getSueldoBasico() + 
        " - Sueldo Cargo: " + this.sueldoDelCargo() + " - Antiguedad: " + this.antiguedad());
        System.out.println("Horas Docencia: " + this.getHorasDeDocencia());
        
    }
    
    /**
     * 
     * setters y getters que corresponden
     * 
     */
    
    
    
    private void setNombreCargo(String p_nombre) {
        
        this.nombreCargo = p_nombre;
        
    }
    
    private void setSueldoBasico(double p_sueldo) {
        
        this.sueldoBasico = p_sueldo;
        
    }
    
    private void setAnioIngreso(int p_anio) {
        
        this.anioIngreso = p_anio;
        
    }
    
    private void setHorasDeDocencia(int p_horas, Scanner teclado) {
        
          while(p_horas > 10) {
            
            System.out.println("No se pueden tener mas de 10 horas de docencia! Ingrese un valor valido");
            p_horas = teclado.nextInt();
            
            
          }
            
          this.horasDeDocencia = p_horas;
            
          
    }
    
    public String getNombreCargo() {
        
        return this.nombreCargo;
        
    }
    
    public double getSueldoBasico() {
        
        return this.sueldoBasico;
    }
    
    public int getAnioIngreso() {
        
        return this.anioIngreso;
        
    }
    
    public int getHorasDeDocencia() {
        
        return this.horasDeDocencia;
        
    }
}