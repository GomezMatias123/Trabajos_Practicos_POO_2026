import java.util.ArrayList;
/**
 * Abstraccion del concepto de un banco, con los atributos pertinentes al problema. Su lista de empleados y datos de la entidad bancaria. 
 * 
 * @author (Gomez Matias Nicolas, Fernandez Fabio Javier)
 * @version (v1.0)
 */
public class Banco
{
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList<Empleado> empleados;

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        ArrayList <Empleado> e = new ArrayList<>();
        e.add(p_empleado);
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(e);
    }

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
    }
    
    /**
     * Getters y setters
     */
    
    public String getNombre() {
        return this.nombre;
    }

    private void setNombre(String p_nombre) {
        nombre = p_nombre;
    }

    public int getNroSucursal() {
        return nroSucursal;
        
    }

    private void setNroSucursal(int p_nroSucursal) {
        nroSucursal = p_nroSucursal;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    private void setLocalidad(Localidad p_localidad) {
        localidad = p_localidad;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    private void setEmpleados(ArrayList<Empleado> p_empleados) {
        empleados = p_empleados;
    }
    
    
    public boolean agregarEmpleado(Empleado p_empleado) {
        Empleado empleadoNuevo = p_empleado;
        empleados.add(empleadoNuevo);
        if(empleados.contains(empleadoNuevo)){
            return true;
        }else {
            return false;
        }
    }

    public boolean quitarEmpleado(Empleado p_empleado) {
        Empleado empleadoNuevo = p_empleado;
        empleados.remove(empleadoNuevo);
        if(empleados.contains(empleadoNuevo)){
            return false;
        }else {
            return true;
        }
    }

    public void listarSueldos() {
        if(empleados.isEmpty()){
            System.out.println("--- Lista vacia ---");
            return;
        } else {
            System.out.println("-----------------------------------");
            for(Empleado e : this.getEmpleados()){
                System.out.println(e.mostrarLinea());
            }
            System.out.println("-----------------------------------");
        }
    }

    public double sueldosAPagar() {
        double totalAPagar = 0;
        for(Empleado e : this.getEmpleados()){
            totalAPagar = totalAPagar + e.sueldoNeto();   
        }
        return totalAPagar;
    }

    public void mostrar() {
        System.out.println("Banco: " + this.getNombre() + " " + "Sucursal: " + this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar());
        listarSueldos();
        System.out.println("Total a Pagar" +  "................. $ " +sueldosAPagar()); 
    }
}
