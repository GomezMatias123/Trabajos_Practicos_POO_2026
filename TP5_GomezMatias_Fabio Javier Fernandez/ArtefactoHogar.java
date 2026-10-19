
/**
 * Clase abstracta que servira molde para artefactos 
 * 
 * @author Fernandez fabio javer, matias nicolas gomez
 * @version (v1.0)
 */
public abstract class ArtefactoHogar
{
    //atributos
    
    private String marca;
    private float precio;
    private int stock;
    
    /**
     * 
     * Costructor de la clase ArtefactoHogar
     * 
     */
    
    public ArtefactoHogar(String p_marca, float p_precio, int p_stock) {
        
        this.setMarca(p_marca);
        
        this.setPrecio(p_precio);
        
        this.setStock(p_stock);
        
    }
    
    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     */
    
    public void imprimir() {
        
        System.out.println("Marca: " + this.getMarca() + "\t - \t Precio: " + this.getPrecio() + "\t - \t Stock: " + this.getStock());
        
    }
    
    /**
     * 
     * retorna un valor que representa las cuotas
     * recibe la cantidad de cuotas y cuyo porcentaje de interes
     * 
     */
    
    public float cuotaCredito(int p_cuotas, float p_interes) {
        
        return (this.getPrecio() * p_interes) / p_cuotas;
        
    }
    
    /**
     * 
     * Es un metodo abstracto que recibe la cantidad de cuotas y cuyo porcentaje de interes
     * retorna la cuota con adicional
     * 
     */
    
    public abstract float creditoConAdicional(int p_cuotas, float p_interes);
    
    /**
     * 
     * setters y getters
     * 
     */
    
    private void setMarca(String p_marca) {
        
        this.marca = p_marca;
        
    }
    
    private void setPrecio(float p_precio) {
        
        this.precio = p_precio;
        
    }
    
    private void setStock(int p_stock) {
        
        this.stock = p_stock;
        
    }
    
    public String getMarca() {
        
        return this.marca;
        
    }
    
    public float getPrecio() {
        
        return this.precio;
        
    }
    
    public int getStock() {
        
        return this.stock;
        
    }
}