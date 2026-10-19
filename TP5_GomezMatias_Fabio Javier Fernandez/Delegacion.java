import java.util.*;
import java.util.HashSet;

/**
 * Clase que hereda de la clase visitante, es una abstraccion de un Delegacion
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Delegacion extends Visitante
{
    //atributos
    
     private HashSet<Individuo> individuos;
     
     /**
      * 
      * constructor de la clase Delegacion
      * 
      */    
    public Delegacion(String p_nombre, Calendar p_fechaVisita, HashSet<Individuo> p_individuos) {
        
        
        super(p_nombre, p_fechaVisita);
        
        this.setIndividuos(p_individuos);
        
    }
    
    public String tipoVisitante() {
        
        return "Delegacion";
        
    }
    
    /**
     * 
     * adder de la clase Delegacion
     * 
     */
    
    public void inscribirIndividuo(Individuo p_individuo) {
        
        if(this.getIndividuos().contains(p_individuo)) {
            
            System.out.println("Esta individuo ya esta inscrito");
            
        } else { 
            
            this.getIndividuos().add(p_individuo);
            
        }
        
    }
    
    /**
     * 
     * remover de la clase respectiva
     * 
     */
    
    public boolean quitarIntegrate(Individuo p_individuo) {
        
        if(this.getIndividuos().size() > 1) {
            
            this.getIndividuos().remove(p_individuo);
            
            return true;
            
        } else {
            
            System.out.println("No se pueden tener menos de 1 individuo");
            
            return false;
            
        }
        
    }
    
    /**
     * 
     * retorna la cantidad de individuos de la Delegacion
     * 
     */
    
    public int cantidadIntegrantes() {
        
        return this.getIndividuos().size();
        
    }
    
    public void mostrar() {
        
        System.out.println("Delegacion: " + this.getNombre());
        System.out.println("Integrantes");
        
        for(Individuo i : this.getIndividuos()) {
            
            i.mostrar();
            
        }
        
        System.out.println("Cantidad de Integrantes: " + this.cantidadIntegrantes());
        
    }
    
    public double entrada() {
        
        return (10 * this.cantidadIntegrantes()) - (10 * this.cantidadIntegrantes()) * 0.10;
        
    }
    
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        
        if(this.getFechaVisita() == p_fecha) {
               
              
              this.mostrar();
             
            
        }
        
    }
    
    public HashSet<Persona>   listarPersonas() {
        
        
        HashSet<Persona> personas = new HashSet<>();
        
        for(Individuo i : this.getIndividuos()) {
            
            personas.add(i.getPersona()); 
            
        }   
            
        return personas;
        
    }
    
    /**
     * Getters y Setters
     */
    
    private void setIndividuos(HashSet<Individuo> p_individuos) {
        
        this.individuos = p_individuos;
        
    }
    
    public HashSet<Individuo> getIndividuos() {
        
        return this.individuos;
        
    }
}