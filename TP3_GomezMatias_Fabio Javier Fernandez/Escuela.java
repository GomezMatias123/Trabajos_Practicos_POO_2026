
/**
 * Abstrae las carateristicas solicitadas de una escuela, permite modficar los atributoss presentados e imprimir 
 * el recibo con las informacion de un docente
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 * 
 */
public class Escuela {
    
    //atributos
    
    private String nombre;
    private String domicilio;
    private String director;
    
    //metodos
    
    /*
     * Constructor de la clase Producto
     * 
     */

    
    public Escuela(  String p_nombre, String p_domicilio, String p_director){
        
        
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setDirector(p_director);
        
        
    }
    
    /*
     * 
     * Imprime por pantalla los datos solicitados por el cliente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * 
     * 
     */
    
    
    
    public void imprimirRecibo(Docente p_docente) {
        
        
        System.out.print("Escuela: " + this.getNombre());
        System.out.print("\t Domicilio: " + this.getDomicilio());
        System.out.println("\t Director: " + this.getDirector());
        System.out.println("-------------------------------------------------------");
        System.out.println("Docente: \t " + p_docente.getNombre() + ".");
        System.out.println("Sueldo: .............................. \t $" 
                            +  p_docente.calcularSueldo());
        System.out.println("Sueldo Basico: .................... \t $" 
                            +   p_docente.getSueldoBasico());
        System.out.println("Asignacion familiar: .............. \t $" 
                            + p_docente.getAsignacionFamiliar());
                            
        
    }
    
    /*
     * 
     * Setters qe corresponden cada clase, cada uno se encarga de settear el atributo correspondiente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     * 
     */
    
    
    
    private void setNombre(String p_nombre) {
        
        this.nombre = p_nombre;
        
    }
    
    private void setDomicilio(String p_domicilio) {
        
        this.domicilio = p_domicilio;
        
    }
    
    private void setDirector(String p_director) {
        
        this.director = p_director;
        
    }
    
    /*
     * 
     * los getters que corresponden a cada clase, cada uno se encarga de retornar el atributo correspondiente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retornan su correspondiente atributo
     * 
     */
    
    public String getNombre() {
        
        return this.nombre;
        
    }
    
    public String getDomicilio() {
        
        return this.domicilio;
        
    }
    
    public String getDirector() {
        
        return this.director;
        
    }


    
}