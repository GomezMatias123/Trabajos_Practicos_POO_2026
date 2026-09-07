
/**
 * Abstraccion del concepto de una caja de ahorros con los atributos que la consigna nos pide, en conjunto con la clase persona para simular el funcionamiento de una caja de ahorro real.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class CajaDeAhorro
{
    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;
    private Persona titular;
 
    
    
    /**
     * Constructores sobrecargadso, permiten realizar instancias de un objeto con saldo o sin saldo
     * 
     * param: datos del mismo tipo que los atributos del objeto.
     * 
     * 
     */
    
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0);
        this.setExtraccionesPosibles(10);
    }
 
    
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setExtraccionesPosibles(10);
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
 
    public int getExtraccionesPosibles() {
       
        return this.extraccionesPosibles;
    }
 
    private void setExtraccionesPosibles(int p_extracciones) {
        this.extraccionesPosibles = p_extracciones;
    }
 
    /**
     * Modifica el atributo de saldo de un objeto CajaDeAhorro mediante una variable del tipo double ingresada por el usuario.
     * 
     * param: Un atributo de tipo double ingresado por teclado
     * 
     * 
     */
    public void depositar(double p_importe) {
        double deposito = this.getSaldo() + p_importe;
        this.setSaldo(deposito);
    }
 
    /**
     * Define si la extraccion de dinero solicitada por el usuario es valida o posible.
     * 
     * param: Un atributo de tipo double ingresado por teclado
     * return: un valor booleano correspondiente a si es posible hacer determinada accion o no.
     * 
     */
    public boolean puedeExtraer(double p_importe) {
        double extraccion = p_importe;
        if(extraccion <= this.getSaldo() && this.getSaldo() > 0 && this.getExtraccionesPosibles() > 0){
        return true;
        } else {
        return false;
        }
    }
 
       /**
         * Realiza la extraccion de dinero solicitada por el usuario cuando es valida.
         * 
         * param: Un atributo de tipo double ingresado por teclado. 
         * 
         */
    private void extraccion(double p_importe) {
        double extraccion = this.getSaldo() - p_importe;
        this.setSaldo(extraccion);
        this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }
 
       /**
         * Inicia el proceso para ver si es posible la extraccion, caso contrario imprime un mensaje que especifica lo contrario
         * 
         * param: Un atributo de tipo double ingresado por teclado. 
         * 
         */
    public void extraer(double p_importe) {
       if(!puedeExtraer(p_importe)){
            System.out.println(this.getExtraccionesPosibles() > 0 ? "No puede extraer mas que el saldo!" : "No tiene habilitadas mas extracciones!");
        } else {
            extraccion(p_importe);
        }
    }
 
    public void mostrar() {
        System.out.println("- Caja de Ahorro -");
        System.out.println("Nro.Cuenta: " + this.getNroCuenta() + " " + "-" + " " + "Saldo: " 
        + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }

}