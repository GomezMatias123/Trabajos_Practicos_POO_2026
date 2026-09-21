import java.util.HashMap;
/**
 * Abstraccion del concepto de un comercio, con los atributos pertinentes al problema. Su lista de empleados y datos de la entidad. 
 * 
 * @author (Gomez Matias Nicolas, Fernandez Fabio Javier)
 * @version (v1.0)
 */
public class Comercio {
    
    //atributos
    
    String nombre;
    HashMap<Long, Empleado> empleados;
    
    //metodos
    
    /**
     * 
     * constructores de la clase comercio
     * 
     */
    
    public Comercio(String p_nombre) {
        
        this.setNombre(p_nombre);
        
        HashMap<Long, Empleado> empleados = new HashMap<>();
        
        this.setEmpleados(empleados);
        

    }
    
    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados) {
        
        this.setNombre(p_nombre);
        
        this.setEmpleados(p_empleados);
        
    }
    
    /**
     * 
     * añade a un empleado al hashmap
     * recibe como parametro un empleado
     * 
     */
    
    public void altaEmpleado(Empleado p_empleado) {
        
        this.getEmpleados().put(p_empleado.getCuil(), p_empleado);
        
    }
    
    /**
     * 
     * quita un empleado del hashmap
     * retorna el empleado que se quito
     * 
     */
    
    public Empleado bajaEmpleado( long p_cuil) {
        
        return this.getEmpleados().remove(p_cuil);
        
    }
    
    /**
     * 
     * retorna la cantidad de empleados
     * 
     */
    
    public int cantidadDeEmpleados() {
        
        return this.getEmpleados().size();
        
    }
    
    /**
     * 
     * revisa si un empleado esta en lista
     * recibe como parametro un cuil
     * retorna un bool dependiendo de estado de la busqueda
     * 
     */    
    public boolean esEmpleado(long p_cuil) {
        
        return  this.getEmpleados().containsKey(p_cuil);
        
    }
    
    /**
     * 
     * busca un empleado a traves de un cuil
     * recibe un cuil
     * retorna un empleado
     * 
     */
    
    public Empleado buscarEmpleado(long p_cuil) {
        
        this.getEmpleados().get(p_cuil).mostrar();
        return this.getEmpleados().get(p_cuil);
        
    }
    
    /**
     * 
     * imprime los datos solicitados
     * recibe un cuil a traves del cual se buscara al empleado solicitado
     * 
     */
    
    public void sueldoNeto(long p_cuil) {
        
        System.out.println(this.getEmpleados().get(p_cuil).mostrarLinea());
    }
    
    /**
     * 
     * imprime los datos solicitados
     * 
     */
    
    public void nomina() {
        
        System.out.println("**** Nomina de empleados de " + this.getNombre() +  "****");
        
        for(HashMap.Entry<Long, Empleado> e : this.getEmpleados().entrySet()) {
            
             System.out.println(e.getValue().mostrarLinea());
            
        }
    }
    
    /**
     * 
     * setters y getters responsables de cada clase
     * 
     */
    
    private void setNombre(String p_nombre) {
        
        this.nombre = p_nombre;
        
    }
    
    private void setEmpleados(HashMap<Long, Empleado> p_empleados) {
        
        this.empleados = p_empleados;
        
    }
    
    public String  getNombre() {
        
        return this.nombre;
        
    }
    
    public HashMap<Long, Empleado>   getEmpleados() {
        
        return this.empleados;
        
    }
    
}