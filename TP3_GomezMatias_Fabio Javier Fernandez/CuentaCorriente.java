
/**
 * Abstraccion del concepto de una cuenta corriente con los atributos que la consigna nos pide, en conjunto con la clase persona para simular el funcionamiento de una cuenta corriente real.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class CuentaCorriente
{
    private int nroCuenta;
    private double saldo;
    private double limiteDescubierto;
    private Persona titular;
 
    // Constructor sin saldo 
    public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0);
        this.setLimiteDescubierto(500);
    }
 
    // Constructor con saldo inicial
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setLimiteDescubierto(500);
    }
 
    // Getters y Setters
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
 
    public double getLimiteDescubierto() {
    
        return this.limiteDescubierto;
    }
 
    private void setLimiteDescubierto(double p_limite) {
        this.limiteDescubierto = p_limite;
    }
 
    // Sólo suma el importe al saldo
    public void depositar(double p_importe) {
        double deposito = p_importe + this.getSaldo();
        this.setSaldo(deposito);
    }
 
    // Devuelve true si el importe no supera saldo + descubierto
    public boolean puedeExtraer(double p_importe) {
        double extraccion = p_importe;
        if(extraccion <= (this.getSaldo() + this.getLimiteDescubierto())){
        return true;
        } else {
        return false;
        }
    }
    // Realizala extracción
    private void extraccion(double p_importe) {
        double extraccion = this.getSaldo() - p_importe;
        this.setSaldo(extraccion);
    }
 
    // Coordina la extracción: llama a puedeExtraer(), y según el resultado
    // ejecuta extraccion() o informa el motivo por el cual no se pudo extraer
    public void extraer(double p_importe) {
        if(!puedeExtraer(p_importe)){
            System.out.println("El importe de extraccion sobrepasa el límite de descubierto!");
        } else {
            extraccion(p_importe);
        }
    }
    
    public void mostrar() {
        System.out.println("-Cuenta Corriente -");
        System.out.println("Nro.Cuenta: " + this.getNroCuenta() + " " + "-" + " " + "Saldo: " 
        + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        System.out.println("Descubierto " + this.getLimiteDescubierto());
    }
}