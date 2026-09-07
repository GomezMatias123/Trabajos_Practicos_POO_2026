
/**
* Abstrae el concepto de un Docente, se implementan metodos para poder manipular los distintos atributos 
* del objeto, asi como  hacer el calcuo del sueldo.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 * 
 */
public class Docente {
    
    
    
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;
    
   
    
    /**
     * 
    * Metodo constructor perteneciente a la clase docente.
    * 
    */
   
    public Docente(String p_nombre, String p_grado, double p_sueldoBasico, double p_asignacionFamiliar) {
        
        this.setNombre(p_nombre);
        this.setGrado(p_grado);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAsignacionFamiliar(p_asignacionFamiliar);
        
    }
    
    /**
     * 
     * Calcula el sueldo del docente al sumar el sueldo basico con la asignacion famiiar del Docente.
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retorna el valor que representa el sueldo 
     * 
     */
    
    
    
    public double calcularSueldo() {
        
        return this.getSueldoBasico() + this.getAsignacionFamiliar();
    }
    
    /**
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
    
    private void setGrado(String p_grado) {
        
        this.grado = p_grado;
        
    }
    
    private void setSueldoBasico(double p_sueldoBasico) {
        
        this.sueldoBasico = p_sueldoBasico;
        
    }
    
    private void setAsignacionFamiliar(double p_asignacionFamiliar) {
        
        this.asignacionFamiliar = p_asignacionFamiliar;
        
    }
    
     /**
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
    
    public String getGrado() {
        
        return this.grado;
        
    }
    
    public double getSueldoBasico() {
        
        return this.sueldoBasico;
        
    }
    
    public double getAsignacionFamiliar() {
        
        return this.asignacionFamiliar;
        
    }
  
}