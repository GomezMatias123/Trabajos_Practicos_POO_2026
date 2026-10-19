
/**
 * Abstraccion del concepto de una cuenta corriente con los atributos que la consigna nos pide, en conjunto con la clase persona para simular el funcionamiento de una cuenta corriente real.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class CuentaCorriente extends Cuenta
{
    private double limiteDescubierto;
 
    /**
     * Constructor sobre cargado para la clase Cuenta Corriente permite realizar instancias de un objeto con saldo o sin saldo
     * 
     * param: datos del mismo tipo que los atributos del objeto.
     * 
     * 
     */
    
    
    
    public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular);
        this.setLimiteDescubierto(500);
    }
 
    
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular);
        this.setLimiteDescubierto(500);
    }
 
    /**
     * Getter y Setters
     * 
     */
    
    public double getLimiteDescubierto() {
    
        return this.limiteDescubierto;
    }
 
    private void setLimiteDescubierto(double p_limite) {
        this.limiteDescubierto = p_limite;
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
        if(extraccion <= (this.getSaldo() + this.getLimiteDescubierto())){
            return true;
        } else {
            return false;
        }
    }
    
    public String xQNoPuedeExtraer(double p_importe) {
        
        return "El importe de extraccion sobrepasa el límite de descubierto!";
                    
    }
                          
    /**
     * Imprime los datos de la cuenta.
     * 
     * 
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("Descubierto " + this.getLimiteDescubierto());
    }
}