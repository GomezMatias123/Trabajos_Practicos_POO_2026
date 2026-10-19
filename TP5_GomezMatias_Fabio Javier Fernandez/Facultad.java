import java.util.ArrayList;
/**
 * Es una abstraccion de una facultad
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Facultad
{
    //atributos
    
    String nombre;
    ArrayList<Profesor> profesores;
    
    /**
     * 
     * Son costructores de la clase facultad
     * 
     */
    
    public Facultad(String p_nombre, ArrayList<Profesor> p_profesores) {
        
        this.setNombre(p_nombre);
        this.setProfesores(p_profesores);
        
    }
    
    public Facultad(String p_nombre, Profesor p_profesor) {
        
        this.setNombre(p_nombre);
        
        ArrayList<Profesor> profesores = new ArrayList<>();
        
        profesores.add(p_profesor);
        
        this.setProfesores(profesores);
        
    }
    
    /**
     * 
     * imprime en pantalla una lista de profesores
     * 
     */
    
    public void nominaProfesores() {
        
        System.out.println("***************Nomina Facultad: FaCENA");
        System.out.println("---------------------------------------------");
        
        for(Profesor p : this.getProfesores()) {
            
            System.out.println(p.mostrarLinea());
            
        }
        
        System.out.println("---------------------------------------------");
        System.out.println("Total a pagar: $" + this.totalAPagar());
        
    }
    
    /**
     * 
     * retorna el sueldo total de todos los profesores
     * 
     */
    
    public double totalAPagar() {
        
        int acumulador = 0;
        
        for(Profesor p : this.getProfesores()) {
            
            acumulador +=  p.sueldoTotal();
            
        }
        
        return acumulador;
        
    }
    
    /**
     * 
     * imprime en pantalla los datos de todos los profesores junto con sus cargos
     * 
     */
    
    public void listarProfesorCargos() {
        
        
        System.out.println("*****Detalle de Profesores y cargos de Facultad FaCENA *****");
        int contador = 0;
        
        
        
        for(Profesor p : this.getProfesores()) {
            
            System.out.println("---------------****---------------");
            p.mostrar();
            contador++; 
            
        }
        
        System.out.println("----------------------------------------------------");
        System.out.println("Hay " + contador + " profesores");
    }
    
    /**
     * 
     * setters, getters, adders y removers
     * 
     */
       
        
    private void setNombre(String p_nombre) {
        
        this.nombre = p_nombre;
        
    }
    
    private void setProfesores(ArrayList<Profesor> p_profesores) {
        
        this.profesores = p_profesores;
        
    }
    
    public String getNombre() {
        
        return this.nombre;
        
    }
    
    public ArrayList<Profesor> getProfesores() {
        
        return this.profesores;
        
    }
    
    public void añadirProfesor(Profesor p_profesor) {
        
        this.getProfesores().add(p_profesor);
        
    }
    
    public void quitarProfesor(Profesor p_profesor) {
        
        if(this.getProfesores().size() <= 1) {
            
            System.out.println("No puede haber menos de un profesor!");
            
        } else {
            
            this.getProfesores().remove(p_profesor);
            
        }
    }
}