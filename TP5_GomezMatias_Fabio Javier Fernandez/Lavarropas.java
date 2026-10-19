
/**
 * Clase que hereda de la clase ArtefactoHogar, es una abstraccion de un lavarropas
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Lavarropas extends ArtefactoHogar
{
    //atributos
    
    private int programas;
    private float kilos;
    private boolean automatico;
    
    /**
     * 
     * Costructor de la clase lavarropas
     * 
     */
    
    public Lavarropas(String p_marca, float p_precio, int p_stock, int  p_programas, float p_kilos, boolean p_automatico) {
        
        super(p_marca, p_precio, p_stock);
        
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);
        
    }
    
    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     */
    
    
    public void imprimir() {
            
        System.out.println("**** Lavarropas ****");
        super.imprimir();
        System.out.println("Programas: " + this.getProgramas());
        System.out.println("Kilos: " + this.getKilos());
        System.out.println("Automatico: " + (this.getAutomatico() ? "Si":"No"));
        
    }
    
    /**
     * 
     * Es un metodo abstracto que recibe la cantidad de cuotas y cuyo porcentaje de interes
     * retorna la cuota con adicional segun si es automatico o no lo es, boolean
     * 
     */
    
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        
        if(this.getAutomatico()) {
            
            return super.cuotaCredito(p_cuotas, p_interes);
            
        } else {
            
            return super.cuotaCredito(p_cuotas, p_interes) - (super.cuotaCredito(p_cuotas, p_interes) * 2 / 100);
            
        }
            
    }
    
    /**
     * 
     * setters y getters
     * 
     */
    
    private void setProgramas(int p_programas) {
        
        this.programas = p_programas;
        
    }
    
    private void setKilos(float p_kilos) {
        
        this.kilos = p_kilos;
        
    }
    
    private void setAutomatico(boolean p_automatico) {
        
        this.automatico = p_automatico;
        
    }
    
    public int getProgramas() {
        
        return this.programas;
        
    }
    
    public float getKilos() {
        
        return this.kilos;
        
    }
    
    public boolean getAutomatico() {
        
        return this.automatico;
        
    }
}
