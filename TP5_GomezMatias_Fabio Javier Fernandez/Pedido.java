import java.util.ArrayList;
/**
 * La clase Pedido, tiene como funcion modelar la abstraccion de un pedido realizado.
 * 
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Pedido
{
    
    private ArrayList <Renglon> renglones;
    
    public Pedido(ArrayList<Renglon> p_renglones){
        this.setRenglon(p_renglones);
    }
    
    public Pedido(Renglon p_renglon){
        ArrayList<Renglon> r = new ArrayList<>();
        r.add(p_renglon);
        this.setRenglon(r);
    }
    
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    private void setRenglon(ArrayList<Renglon> p_renglones){
        this.renglones = p_renglones;
    }
    public ArrayList<Renglon> getRenglones(){
        return this.renglones;
    }
    
    /**
     * 
     * Muestra los renglones del pedido completo, suma los totales de etiquetas de cada tipo y el precio individual de cada renglon, al final muestra el total de las etiquetas y el total del 
     * pedido completo.
     * 
     */
    public void mostrar(){
        int i = 0;
        System.out.println("Pedido: ");
        System.out.println("Cantidad de items: " + this.getRenglones().size());
        for(Renglon r : this.getRenglones()){
            System.out.print("Item " + (i+1) + ": ");
            r.mostrar();
            System.out.println("Precio: " + "$ " + r.getPrecio());
            i++;
        }
        System.out.println("--- Total pedido: " + this.totalEtiquetas() + " " + "Etiquetas por un importe total de: $" + " " + this.totalPedido());
    }
    
    /**
     * 
     * Devuelve el total del pedio entre todas la etiquetas de cada renglon.
     * 
     */
    private double totalPedido(){
        double  totalPedido = 0;
        for(Renglon r : this.getRenglones()){
            totalPedido += r.getPrecio();
        }
        return totalPedido;
    }
    /**
     * 
     * Devuelve el total de las etiquetas del pedido completo, sin importar si son premiun o comunes.
     * 
     */
    
    private int totalEtiquetas(){
        int etiquetas = 0;
        for(Renglon r : this.getRenglones()){
            etiquetas += r.getCantidad();
        }
        return etiquetas;
    }
}