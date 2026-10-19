
/**
 * Abstraccion del concepto de una caja de ahorros con los atributos que la consigna nos pide, en conjunto con la clase persona para simular el funcionamiento de una caja de ahorro real.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class CajaDeAhorro extends Cuenta
{
                                
    private int extraccionesPosibles;
    
    /**
     * Constructores sobrecargado, permiten realizar instancias de un objeto con saldo o sin saldo
     * 
     * param: datos del mismo tipo que los atributos del objeto.
     * 
     * 
     */
    
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular);
        this.setExtraccionesPosibles(10);
    }
 
    
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.setExtraccionesPosibles(10);
    }
 
    public int getExtraccionesPosibles() {
       
        return this.extraccionesPosibles;
    }
 
    private void setExtraccionesPosibles(int p_extracciones) {
        this.extraccionesPosibles = p_extracciones;
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
    protected void extraccion(double p_importe) {
        super.extraccion(p_importe);
        this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }
                     
    public String xQNoPuedeExtraer(double p_importe) {
        
        return (this.getExtraccionesPosibles() > 0 ? "No puede extraer mas que el saldo!" : "No tiene habilitadas mas extracciones!");
                    
    }
 
    public void mostrar() {
        super.mostrar();
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }

}