
/**
 * Clase abstracta que servira molde para cuentas bancarias
 * 
 * @author Fernandez fabio javer, matias nicolas gomez
 * @version (v1)
 */
public abstract class Cuenta
{
    
    private int nroCuenta;
    private double saldo;
    private Persona titular;
    
    /**
     * Constructores sobrecargado, permiten realizar instancias de un objeto con saldo o sin saldo
     * 
     * param: datos del mismo tipo que los atributos del objeto.
     * 
     * 
     */
    
    public Cuenta(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0);
                            
    }
 
    
    public Cuenta(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
                            
    }
 
    /**
     *Getters y Setters
     */
    public int getNroCuenta() {
        
        return this.nroCuenta;
    }
 
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }
 
    public double getSaldo() {
       
        return this.saldo;
    }
 
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }
 
    public Persona getTitular() {
        
        return this.titular;
    }
 
    public void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }
    
    /**
     * Modifica el atributo de saldo de un objeto Cuenta Corriente mediante una variable del tipo double ingresada por el usuario.
     * 
     * param: Un atributo de tipo double ingresado por teclado
     * 
     * 
     */
    public void depositar(double p_importe) {
        double deposito = p_importe + this.getSaldo();
        this.setSaldo(deposito);
    }
    
    /**
     * Realiza la extraccion de dinero solicitada por el usuario cuando es valida.
     * 
     * param: Un atributo de tipo double ingresado por teclado. 
     * 
     */
    protected void extraccion(double p_importe) {
        double extraccion = this.getSaldo() - p_importe;
        this.setSaldo(extraccion);
    }
    
    /**
         * Inicia el proceso para ver si es posible la extraccion, caso contrario imprime un mensaje que especifica lo contrario
         * 
         * param: Un atributo de tipo double ingresado por teclado. 
         * 
         */
    public void extraer(double p_importe) {
       if(!puedeExtraer(p_importe)){
            System.out.println(this.xQNoPuedeExtraer(p_importe));
        } else {
            extraccion(p_importe);
        }
    }
    
    /**
     * 
     * Retorna una sentencia que explica porque no puede extraer dependiendo de que tipo de cuenta sea
     * Recibe un importe que indicara si el fallo es por falta de saldo o por otro suceso
     * Es un metodo abstracto
     * 
     */
    
    public abstract String xQNoPuedeExtraer(double p_importe);
    
    /**
     * 
     * comprueba si puede extraerse el importe que se desea obtener, retornando un valor booleano
     * recibe un importe que se desea extraer
     * Es un metodo abstracto
     */
    
    public abstract boolean puedeExtraer(double p_importe);
    
    /**
     * Imprime los datos de la cuenta.
     * 
     * 
     */
    public void mostrar() {
        System.out.println("-Cuenta Corriente -");
        System.out.println("Nro.Cuenta: " + this.getNroCuenta() + " " + "-" + " " + "Saldo: " 
        + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
                
    }
}