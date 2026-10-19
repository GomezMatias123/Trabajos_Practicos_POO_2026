import java.util.HashSet;
import java.util.*;
/**
 * Una abstraccion de un zoo
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Zoologico
{
    
    //atributos
    
    private String nombre;
    
    private  HashSet<Visitante> visitantes;
    
    /**
     * 
     * constructores de la clase Zoologico
     * 
     */
    
    public Zoologico(String p_nombre, HashSet<Visitante> p_visitantes) {
        
        this.setNombre(p_nombre);
        this.setVisitantes(p_visitantes);
        
    }
    
    public Zoologico(String p_nombre) {
        
        this.setNombre(p_nombre);
        
        HashSet<Visitante> visitantes = new HashSet<>();
        
        this.setVisitantes(visitantes);
        
    }
    
    /**
     * 
     * adders y remover de la clase zoo
     */
    
    public void nuevoVisitante(Visitante p_visitante) {
        
        this.getVisitantes().add(p_visitante);
        
    }
    
    public boolean quitarVisitante(Visitante p_visitante) {
        
        if(this.getVisitantes().contains(p_visitante)) {
            
            this.getVisitantes().remove(p_visitante);
            
            return true;
            
        } else {
            
            System.out.println("Este visitante no se encuentra inscripto");
            
            return false;
            
        }
    }
    
    /**
     * 
     * lista a los visitantes de un tipo en particular en una fecha en particular.
     * 
     */
    
    public void listarTipoVisitantePorFecha(Calendar p_fecha, String p_visitante) {
        
        for(Visitante v : this.getVisitantes()) {
            
            System.out.println("-----------------------------------------------");
            v.listarPorFecha(p_fecha, p_visitante);
            
        }
        
    }
    
    /**
     * 
     * lista a los visitantes en una fecha en particular
     */
    
    public void listarVisitantePorFecha(Calendar p_fecha) {
        
        for(Visitante v : this.getVisitantes()) {
            
            System.out.println("-----------------------------------------------");
            v.listarPorFecha(p_fecha,  v.tipoVisitante());
            
        }
        
    }
    
    /**
     * 
     * retorna la cantidad de visitantes del zoo
     *
     */
    
    public int cantidadIntegrantes() {
        
        return this.getVisitantes().size();
        
    }
    
    /**
     * 
     * retorna la racaudacion del zoo dependiendo de p_fechaDesde y p_fechaHasta
     * 
     */
    
    public double recaudaciones(Calendar p_fechaDesde, Calendar p_fechaHasta) {
        
        int acumulador = 0;
        
        for(Visitante v : this.getVisitantes()) {
            
            if(v.getFechaVisita().after(p_fechaDesde) &&  v.getFechaVisita().before(p_fechaHasta)) {
                
                acumulador += v.entrada();
                
            }
            
        }
        
        return acumulador;
        
    }
    
    /**
     * 
     * retorna una coleccion de personas que visitaron el zoo
     */
    
    public HashSet<Persona>   listarPersonasQueVisitaronElZoo() {
        
        
        HashSet<Persona> personas = new HashSet<>();
        
        for(Visitante v : this.getVisitantes()) {
            
            personas.addAll(v.listarPersonas());
            
        }   
            
        return personas;
        
    }
    
    /**
     * Getters y Setters
     */

    
    private void setVisitantes( HashSet<Visitante> p_visitantes) {
        
        this.visitantes = p_visitantes;
        
    }
    
    private void setNombre(String p_nombre) {
        
        this.nombre = p_nombre;
        
    }
    
    public String getNombre() {
        
        
        return this.nombre;
        
        
    }
    
    public HashSet<Visitante> getVisitantes() {
        
         return this.visitantes;
         
    }
}