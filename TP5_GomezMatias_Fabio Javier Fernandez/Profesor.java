import java.util.*;
import java.util.ArrayList;
/**
 * Es una abstraccion de un profesor
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Profesor extends Persona
{
    //atributos
    
    private String titulo;
    private ArrayList<Cargo> cargos;
    
    
    /**
     * 
     * Constructores de la clase profesor
     * 
     */
    public Profesor(int p_dni, String p_nombre, String p_apellido, int p_anio, String p_titulo, Cargo p_cargo) {
        
        super(p_dni, p_nombre, p_apellido, p_anio);
        
        ArrayList<Cargo> cargos = new ArrayList<>();
        cargos.add(p_cargo);
        
        this.setTitulo(p_titulo);
        this.setCargos(cargos);
        
    }
    
    public Profesor(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha, String p_titulo, ArrayList<Cargo> p_cargos) {
        
        super(p_dni, p_nombre, p_apellido, p_fecha);
        
        this.setTitulo(p_titulo);
        
        this.setCargos(p_cargos);
        
    }
    
    public Profesor(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha, String p_titulo, Cargo p_cargo) {
        
        super(p_dni, p_nombre, p_apellido, p_fecha);
        
        
        this.setCargos (new ArrayList<>());
        this.añadirCargo(p_cargo);
        
        this.setTitulo(p_titulo);
        
    }
    
    public Profesor(int p_dni, String p_nombre, String p_apellido, int p_anio, String p_titulo, ArrayList<Cargo> p_cargos) {
        
        super(p_dni, p_nombre, p_apellido, p_anio);
        
        this.setTitulo(p_titulo);
        
        this.setCargos(p_cargos);
        
    }
    
    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     */
    
    public void mostrar() {
        
        super.mostrar();
        this.listarCargos();
        
        System.out.println("\n**Sueldo Total: " + this.sueldoTotal() + "**");
        
    }
    
    /**
     * 
     * imprime en pantalla la lista de cargos asignados a un profesor
     * 
     */
    
    public void  listarCargos() {
        
        System.out.println("-*****Cargos Asignados*****-");
        
        for(Cargo e : this.getCargos()) {
            
            e.mostrarCargo();
            
        
            System.out.println();
        }
    }
    
    /**
     * 
     * calcula el sueldo total de un profesor
     * 
     */


    public double sueldoTotal() {
        
        double acumulador = 0;
        
        for(Cargo e : this.getCargos()) {
            
            acumulador += e.sueldoDelCargo();
            
            
        }
        
        return acumulador;
        
    }
    
    /**
     * 
     * retorna una candena con los datos solicitados
     * 
     */
    
    
    public String mostrarLinea() {
        
        return "DNI: " +      this.getDNI() + " - Nombre: " +  this.nomYApe() + " - Sueldo Total: " + this.sueldoTotal();
        
    }
    
    /**
     * 
     * setters getter, adders y removers 
     */
    
    private void setTitulo(String p_titulo) {
        
        this.titulo = p_titulo;
        
    }
    
    private void setCargos(ArrayList<Cargo> p_cargos) {
        
        this.cargos = p_cargos;
        
    }
    
    public String  getTitulo() {
        
        return this.titulo;
        
    }
    
    public ArrayList<Cargo> getCargos() {
        
        return this.cargos;
        
    }
    
    public boolean añadirCargo(Cargo p_cargo) {
        
        
        if(this.getCargos().size() >= 3) {
            
            System.out.println("\nSolo se pueden tener hasta tres cargos!");
            
            return false;
            
        } else {
            
            
            this.getCargos().add(p_cargo);
            
        }
        
        return this.getCargos().contains(p_cargo);
        
    }
    
    
    public boolean quitarCargo(Cargo p_cargo) {
        
        if(this.getCargos().size() <= 1) {
            
            System.out.println("No se pueden tener menos de 1 cargo!");
            
        } else {
            
            this.getCargos().remove(p_cargo);
            
        }
        
        return !this.getCargos().contains(p_cargo);
        
    }
    
}