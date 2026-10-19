

/**
 * La clase Renglon, tiene como funcion modelar la contruccion de un renglon donde se espefica los datos de un pedido especifico.
 * 
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Renglon
{
    private int cantidad;
    private double precio;
    private Etiqueta item;
    
    public Renglon(int p_cantidad, Etiqueta p_item){
        this.setCantidad(p_cantidad);
        this.setItem(p_item);
        this.setPrecio();
    }
    
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setCantidad(int p_cantidad){
        this.cantidad = p_cantidad;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    private void setPrecio(){
        this.precio = this.getItem().precio(this.getCantidad());
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    private void setItem(Etiqueta p_item){
        this.item = p_item;
    }
    
    public Etiqueta getItem(){
        return this.item;
    }
    
    /**
     * 
     * Imprime la informacion general de un renglon correspondiente al pedido.
     * 
     */
    public void mostrar(){
        System.out.println(this.getCantidad() + " Etiquetas de "+ this.getItem().toString());
    }
    
    
}