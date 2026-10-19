import java.util.*;
import java.util.HashSet;
/**
 * Clase abstracta que servira molde para visitantes
 * 
 * @author Fernandez fabio javer, matias nicolas gomez
 * @version (v1)
 */
public abstract class Visitante
{
    //atributos
    
    private String nombre;
    private Calendar fechaVisita;
    
    /**
     * 
     * constructor de las clase visitante
     * 
     */
    
    public Visitante(String p_nombre, Calendar p_fechaVisita) {
        
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
        
    }
    
    /**
     * 
     * metodo abstracto, imprime los datos que se solicite en cada caso
     * 
     */
    
    public abstract void mostrar();
    
    /**
     * 
     * metodo abstracto, retorna un valor que representa el precio de entrada dependiendo de cada caso
     * 
     */
    
    public abstract double entrada();
    
    /**
     * 
     * metodo abstracto, imprime los visitantes que visitaron en dependiendo de la fechaVisita
     * recibe p_fechaVisita y p_visitante, que es lo que indicara que imprime en cada caso
     */
    
    public abstract void listarPorFecha(Calendar p_fechaVisita, String p_visitante);
    
    /**
     * 
     * metodo abstracto, retorna una sentencia dependendiendo de que tipo de visitante sea
     * 
     */
    
    public abstract String tipoVisitante();
    
    /**
     * 
     * metodo abstracto, retorna una coleccion de personas que visitaron
     * 
     */
    
    public abstract HashSet<Persona> listarPersonas();
    
    /**
     * 
     * Getters y Setters
     *
     */
    
    private void setNombre(String p_nombre) {
        
        this.nombre = p_nombre;
        
    }
    
    private void setFechaVisita(Calendar p_fechaVisita) {
        
        this.fechaVisita = p_fechaVisita;
        
    }
    
    public String getNombre() {
        
        return this.nombre;
        
    }
    
    public Calendar  getFechaVisita() {
        
        return this.fechaVisita;
        
    }
}