
/**
 * Abstraccion del concepto de una cuenta bancaria con los atributos que la consigna nos pide, en conjunto con la clase persona para simular el funcionamiento de una cuenta bancaria real.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class CuentaBancaria
{
    // Atributos
    private int nroCuenta;
    private double saldo;
    private Persona titular;
 
    
    public CuentaBancaria(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
         this.setSaldo(0);
    }
 
    
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }
 
    // Getters y Setters
    public int getNroCuenta() {
        return this.nroCuenta;
    }
 
    private void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
 
    public double getSaldo() {
        return this.saldo;
    }
 
    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
    public Persona getTitular() {
        return this.titular;
    }
 
    private void setTitular(Persona titular) {
        this.titular = titular;
    }   
 
    // Métodos del diagrama
    public double depositar(double p_importe) {
        double deposito = this.getSaldo() + p_importe;
        this.setSaldo(deposito);
        return deposito;
    }
 
    public double extraer(double p_importe) {
        double extraccion = this.getSaldo() - p_importe;
        this.setSaldo(extraccion);
        return extraccion;  
    }
 
    public void mostrar() {
        System.out.println("-Cuenta Bancaria-");
        System.out.println("Titular: " + this.getTitular().nomYApe() + " " + "(" + 
        this.getTitular().edad() + ")");
        System.out.println("Saldo: $" + this.getSaldo());
    }
 
    public String toString() {
        
        return this.getNroCuenta() + " " + this.getTitular().nomYApe() + this.getSaldo();
    }

    
}