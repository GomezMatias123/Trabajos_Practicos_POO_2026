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
    
    /**
     * 
     * 
     * Constructores sobrecargados de la clase banco
     * 
     * 
     */

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
     * Getters y setters, adders y removers
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
    
    /**
     * 
     * 
     * Imprime la lista de datos solicitada
     */

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
    
    /**
     * 
     * calcula la cantidad total a pagar de los sueldos de los empleados a traves de un acumulador
     * retorna un double que representa la cantidad a pagar de los sueldos
     * 
     */

    public double sueldosAPagar() {
        double totalAPagar = 0;
        for(Empleado e : this.getEmpleados()){
            totalAPagar = totalAPagar + e.sueldoNeto();   
        }
        return totalAPagar;
    }
    
    /**
     * 
     * imprime los datos solicitados
     * 
     */

    public void mostrar() {
        System.out.println("Banco: " + this.getNombre() + " " + "Sucursal: " + this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar());
        listarSueldos();
        System.out.println("Total a Pagar" +  "................. $ " + this.sueldosAPagar()); 
    }
    
    /**
     * 
     * agrega una cuentaBancaria
     * retorna un bool que depende de si se logro añadir la cuenta
     */
    
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta) {
        CuentaBancaria nuevaCuenta = p_cuenta;
        this.getCuentas().add(nuevaCuenta);
        if(this.getCuentas().contains(nuevaCuenta)){
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * 
     * quita una cuenta bancaria
     * retorna un bool dependiendo de si se logro remover la cuenta
     */

    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta) {
        CuentaBancaria eliminarCuenta = p_cuenta;
        this.getCuentas().remove(eliminarCuenta);
        if(this.getCuentas().contains(eliminarCuenta)){
            return false;
        }else {
            return true;
        }
    }
    
    /**
     * 
     * imprime una lista de las cuentas que tiene saldo 0
     */
    
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
    
    /**
     * 
     * crea una lista de titurales
     * retorna un HashSet de los titulares de laws cuentas
     * 
     */
    
    public HashSet<Persona> listaDeTitulares(){
        HashSet<Persona> titulares = new HashSet<>();
        for (CuentaBancaria c : this.getCuentas()){
            titulares.add(c.getTitular());
        }
        return titulares;
    }
    
    /**
     * 
     * cuenta la cantidad de cuentas activas con saldo mayor a 0 con un acumulador
     * retorna un valor int que simula ser la cantidad de cuentas activas 
     */
    
    private int cuentasSaldoActivo(){
        int cuentasActivas = 0;
        for(CuentaBancaria c : this.getCuentas()){
            if(c.getSaldo() > 0){
                cuentasActivas++;
            } 
        }
        return cuentasActivas;
    }
    
    /**
     * 
     * imprime los datos solicitados
     * 
     * 
     */
    
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
