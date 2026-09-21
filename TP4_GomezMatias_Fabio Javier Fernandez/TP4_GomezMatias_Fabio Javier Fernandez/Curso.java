import java.util.HashMap; 
/**
 * Abstraccion del concepto de un curso, con los atributos pertinentes al problema. Su lista de alumnos y datos de la entidad. 
 * 
 * @author (Gomez Matias Nicolas, Fernandez Fabio Javier)
 * @version (v1.0)
 */
public class Curso{
    
    
    // atributos
    String nombre;
    HashMap<Integer, Alumno> alumnos;
    
    //metodos
    
    /**
     * 
     * constructor del objeto Curso
     */
    
    public Curso(String p_nombre) {
        
        this.setNombre(p_nombre);
        
        HashMap<Integer, Alumno> alumnos = new HashMap<>();
        
        this.setAlumnos(alumnos); 
        
    }
    
    public Curso(String p_nombre, HashMap p_alumnos) {
        
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
        
    }
    
    /**
     * 
     * añade un alumno al HashMap
     * recibe un valor Alumno que representa un alumno
     */
    
    
    public void inscribirAlumno(Alumno p_alumno) {
        
        this.getAlumnos().put(p_alumno.getLU(), p_alumno);
        
    }
    
    /**
     * 
     * quita un alumno del hashmap
     * retorna un valor Alumno que es el que se removio
     */
    
    public Alumno quitarAlumno(int p_lu) {
        
        return this.getAlumnos().remove(p_lu);
        
    }
    
    /**
     * 
     * retorna un valor int que representa la cantidad de alumnos
     * 
     */
    
    public int cantidadDeAlumnos() {
        
        return this.getAlumnos().size();
        
    }
    
    /**
     * 
     * revisa en el hashmap si el alumno esta inscripto
     * recibe como parametro la libreta universitaria del alumno que se quiere buscar
     * retorna un valor bool dependiendo de si se encontro al alumno
     * 
     */
    
    public boolean estaInscripto(int p_lu) {
        
        return this.getAlumnos().containsKey(p_lu);
        
    }
    
    /**
     * 
     * revisa en el hashmap si el alumno esta inscripto
     * recibe como parametro al  alumno que se quiere buscar
     * retorna un valor bool dependiendo de si se encontro al alumno
     * 
     */
    
    public boolean estaInscripto(Alumno p_alumno) {
        
        return this.getAlumnos().containsValue(p_alumno);
        
    }
    
    /**
     * 
     * revisa en el hashmap si el alumno esta inscripto
     * recibe como parametro la libreta universitaria del alumno que se quiere buscar
     * retorna un valor Alumno al encontrar al alumno
     * 
     */
    
    public Alumno buscarAlumno(int p_lu) {
        
        this.getAlumnos().get(p_lu).mostrar();
        return this.getAlumnos().get(p_lu);
        
    }
    
    /**
     * 
     * imprime en pantalla lo solicitado
     * 
     */
     
    public void imprimirPromedioDeAlumno(int p_lu) {
        
        System.out.println("*****--Mostrar promedio del alumno con numero de libreta 30123 --****");
        System.out.println("Promedio: "  + this.getAlumnos().get(p_lu).promedio());
        
    }
    
    /**
     * 
     * imprime en pantalla lo solicitado
     */
    
    public void mostrarInscriptos() {
        
        System.out.println("****-- Cantidad de inscriptos: " + this.cantidadDeAlumnos());
        for(HashMap.Entry<Integer, Alumno> a : this.getAlumnos().entrySet()) {
            
            System.out.println(a.getKey() + " " + a.getValue().nomYApe());
            
        }
    }
    
    /**
     * 
     * setters y getters que corresponden a cada atributo
     */
    
    
    

    
    private void setNombre(String p_nombre) {
        
        this.nombre = p_nombre;
        
    }
    
    private void setAlumnos(HashMap p_alumnos) {
        
        this.alumnos = p_alumnos;
        
    }
    
    public String getNombre() {
        
        return this.nombre;
        
    }
    
    public HashMap<Integer, Alumno> getAlumnos() {
        
        return alumnos;
        
    }
    
    
    
    
    
    
}