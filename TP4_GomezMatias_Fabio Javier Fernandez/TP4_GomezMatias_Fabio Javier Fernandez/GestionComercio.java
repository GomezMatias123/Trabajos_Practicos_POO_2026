
/**
 * Modelado de la interfaz publica de la clase comercio.
 * 
 * @author (Gomez Matias Nicolas, Fernandez Fabio Javier) 
 * @version (v1.0)
 */
public class GestionComercio {
    
    public static void main(String [] args) { 
        Comercio comercio1 = new Comercio("v-code");
        
        Empleado empleado = new Empleado(30100623, "Martinez" , "Virginia", 200000, 2011);
        
        comercio1.altaEmpleado(empleado);
        
        empleado = new Empleado(30200623, "Rolan" , "Rolon", 200000, 2011);
        
        comercio1.altaEmpleado(empleado);
        
        empleado = new Empleado(30300623, "Zackary" , "Zack", 200000, 2011);
        
        comercio1.altaEmpleado(empleado);
        
        comercio1.nomina();
        
        System.out.println("\n-----------------------------------\n");
        
        System.out.println("Se ha retirado al empleado " + comercio1.bajaEmpleado(30100623));
        
        System.out.println("\n-----------------------------------\n");
        
        comercio1.nomina();
        
        System.out.println("\n-----------------------------------\n");
        
        comercio1.sueldoNeto(30200623);
        
        System.out.println("\n-----------------------------------\n");
        
        System.out.println(comercio1.esEmpleado(30300623) ? comercio1.buscarEmpleado(30300623).mostrarLinea() : "El empleado que busca no existe");
        
        
    
    }
    
}