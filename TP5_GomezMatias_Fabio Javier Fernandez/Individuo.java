import java.util.*;

/**
 * Clase que hereda de la clase visitante, es una abstraccion de un individuo
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Individuo extends Visitante
{
    //atributos
    
    private Persona persona;
    
    /**
     * 
     * constructor de la clase individuo
     * 
     */
    
    public Individuo(String p_nombre, Calendar p_fechaVisita, Persona p_persona) {
        
        super(p_nombre, p_fechaVisita);
        this.setPersona(p_persona);
        
    }
    
    public String tipoVisitante() {
        
        return "Individuo";
        
    }
    
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
            
        if(this.getFechaVisita() == p_fecha) {
               
              
              this.mostrar();
             
            
        }
             
    }
    
    public void mostrar() {
        
        this.getPersona().mostrar();
        
    }
    
    public double entrada() {
        
        return 10;
        
    }
    
    
    public HashSet<Persona>   listarPersonas() {
        
        
        HashSet<Persona> personas = new HashSet<>();
        
        
        personas.add(this.getPersona());
        
        return personas;
        
    }
    
    /**
     * Getters y Setters
     */
    
    private void setPersona(Persona p_persona) {
        
        this.persona = p_persona;
        
    }
    
    public Persona getPersona() {
        
        return this.persona;
        
    }
}