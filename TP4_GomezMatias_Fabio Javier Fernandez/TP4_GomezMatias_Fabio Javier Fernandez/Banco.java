import java.util.ArrayList;
import java.util.HashSet;
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
    private ArrayList <CuentaBancaria> cuentas;

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        ArrayList <Empleado> e = new ArrayList<>();
        e.add(p_empleado);
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(e);
        this.setCuentas(new ArrayList<CuentaBancaria>());
    }

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentas(new ArrayList<CuentaBancaria>());
    }
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados, ArrayList<CuentaBancaria> p_cuentas) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentas(p_cuentas);
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
    
    public ArrayList<CuentaBancaria> getCuentas(){
        return cuentas;
    }
    
    private void setCuentas(ArrayList<CuentaBancaria> p_cuentas){
        cuentas = p_cuentas;
    }
    
    public boolean agregarEmpleado(Empleado p_empleado) {
        Empleado empleadoNuevo = p_empleado;
        this.getEmpleados().add(empleadoNuevo);
        if(this.getEmpleados().contains(empleadoNuevo)){
            return true;
        }else {
            return false;
        }
    }

    public boolean quitarEmpleado(Empleado p_empleado) {
        Empleado empleadoNuevo = p_empleado;
        this.getEmpleados().remove(empleadoNuevo);
        if(this.getEmpleados().contains(empleadoNuevo)){
            return false;
        }else {
            return true;
        }
    }

    public void listarSueldos() {
        if(this.getEmpleados().isEmpty()){
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
        System.out.println("Total a Pagar" +  "................. $ " + this.sueldosAPagar()); 
    }
    
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta) {
        CuentaBancaria nuevaCuenta = p_cuenta;
        this.getCuentas().add(nuevaCuenta);
        if(this.getCuentas().contains(nuevaCuenta)){
            return true;
        }else {
            return false;
        }
    }

    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta) {
        CuentaBancaria eliminarCuenta = p_cuenta;
        this.getCuentas().remove(eliminarCuenta);
        if(this.getCuentas().contains(eliminarCuenta)){
            return false;
        }else {
            return true;
        }
    }
    
    public void listarCuentasConSaldoCero(){
        System.out.println("Cuentas sin saldo: ");
        System.out.printf("%-15s%-30s%n", "Cuenta ---", "Apellido y Nombre ---");
        for(CuentaBancaria c : this.getCuentas()){
            if(c.getSaldo() == 0){
                System.out.println(c.toString());
            }
        }
        System.out.println("---------------------------------------------------");
    }
    
    public HashSet<Persona> listaDeTitulares(){
        HashSet<Persona> titulares = new HashSet<>();
        for (CuentaBancaria c : this.getCuentas()){
            titulares.add(c.getTitular());
        }
        return titulares;
    }
    
    private int cuentasSaldoActivo(){
        int cuentasActivas = 0;
        for(CuentaBancaria c : this.getCuentas()){
            if(c.getSaldo() > 0){
                cuentasActivas++;
            } 
        }
        return cuentasActivas;
    }
    
    public void mostrarResumen(){
        System.out.println("Banco: " + this.getNombre() + " " + "Sucursal: " + this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar());
        System.out.println("*******************************************");
        System.out.println("RESUMEN DE CUENTAS BANCARIAS");
        System.out.println("*******************************************");
        System.out.println("Numero Total de Cuentas: " + this.getCuentas().size());
        System.out.println("Cuentas Activas: " + this.cuentasSaldoActivo());
        System.out.println("Cuentas Saldo Cero: " + (this.getCuentas().size() - this.cuentasSaldoActivo()));
        System.out.println("*******************************************");
        this.listarCuentasConSaldoCero();
        System.out.println("Lista de Titulares");
        for(Persona titular : this.listaDeTitulares()){
            System.out.print(titular.apeYNom() + " ");
        }
        System.out.println();
        System.out.println("*******************************************");
    }
}
