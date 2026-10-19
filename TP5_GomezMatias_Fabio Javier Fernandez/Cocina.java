
/**
 * Clase que hereda de la clase ArtefactoHogar, es una abstraccion de un cocina
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Cocina extends ArtefactoHogar
{
    
    //atributos
    
    private int hornallas;
    private int calorias;
    private String dimensiones;
    
    /**
     * 
     * Es un constructor de la clase cocina
     */
    
    
    public Cocina(String p_marca, float p_precio, int p_stock, int p_hornallas, int p_calorias, String p_dimensiones) {
        
        super(p_marca, p_precio, p_stock);
        
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
        
    }
    
    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     */
    
    public void imprimir() {
        
        System.out.println("**** Cocina ****");
        super.imprimir();
        System.out.println("Hornallas: " + this.getHornallas());
        System.out.println("Calorias: " + this.getCalorias());
        System.out.println("Dimesiones: " + this.getDimensiones());
        
    }
    
    /**
     * 
     * Es un metodo abstracto que recibe la cantidad de cuotas y cuyo porcentaje de interes
     * retorna la cuota con adicional que en este caso no posee adicional
     * 
     */
    
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        
        return cuotaCredito(p_cuotas, p_interes);
        
    }
    
    /**
     * 
     * setters y getters
     * 
     */

    
    private void setHornallas(int p_hornallas) {
        
        this.hornallas = p_hornallas;
        
    }
    
    private void setCalorias(int p_calorias) {
        
        this.calorias = p_calorias;
        
    }
    
    private void setDimensiones(String p_dimensiones) {
        
        this.dimensiones = p_dimensiones;
        
    }
    
    public int getHornallas() {
        
        return this.hornallas;
        
    }
    
    public int getCalorias() {
        
        return this.calorias;
        
    }
    
    public String getDimensiones() {
        
        return this.dimensiones;
        
    }
}