import java.util.*;
import java.util.ArrayList;

/**
 * Es una abtraccion un pedido realizado por un cliente.
 * 
 * @author (Gomez Matias Nicolas, Fernandez Fabio Javier)
 * @version (v1.0)
 */
public class Pedido {
    
    //atributos
    
    private Calendar fecha;
    private ArrayList productos;
    private Cliente clientes;
    
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList<Producto> p_productos) {
        
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
                      
    }
    
    /**
     * 
     * constructores de la clase pedido
     * 
     */
    
    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_productos) {
        
        ArrayList p = new ArrayList<>();
        p.add(p_productos);
        
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p);
                      
    }
    
    /**
     * 
     * calcula el total al contado de los productos
     * retorna el total al contado de la lista
     * 
     */
    
    public double totalAlContado() {
        
        double acumulador = 0;
        
        for(int i = 0; i< this.getProductos().size(); i++) {
            
            Producto p = (Producto)  this.getProductos().get(i);
            
            acumulador += p.precioContado();
            
        }
        
        return acumulador;
    }
    
    /**
     * 
     * calcula el total al contado de los productos
     * retorna el total al contado de la lista
     * 
     */
    
    public double totalFinanciado() {
        
        double acumulador = 0;
        
        for(int i = 0; i< this.getProductos().size(); i++) {
            
            Producto p = (Producto)  this.getProductos().get(i);
            
            acumulador += p.precioLista();
            
        }
        
        return acumulador;
    }
    
    /**
     * 
     * agrega un producto a la lista 
     * retorna un bool dependiendo del exito al añadir al producto
     * 
     */
    
    public boolean agregarProducto(Producto p_producto) {
        Producto ingresoProducto = p_producto;
        productos.add(ingresoProducto);
        if(productos.contains(ingresoProducto)){
            return true;
        }else {
            return false;
        }
        
    }
    
    /**
     * 
     * cquita un producto de la lista
     * al finalizar retorna un bool segun que resultado se haya dado al quitar el producto
     * 
     */
    
    public boolean quitarProducto(Producto p_producto) {
        Producto  retiroProducto = p_producto;
        productos.remove(retiroProducto);
        if(productos.contains(retiroProducto)){
            return false;
        }else {
            return true;
        }
        
    }
    
    /**
     * 
     * imprime los datos solicitados
     * 
     */
    
    public void mostrar() {
        
        System.out.println("******Detalle de pedido****** " + 
                           this.mostrarFecha());
        System.out.println(String.format("%-25s %-15s %-15s", "Producto", "Precio Lista", "Precio Contado"));
        
        System.out.println("-------------------------------------------");
        for(int i = 0; i< this.getProductos().size(); i++) {
            
            Producto p = (Producto)  this.getProductos().get(i);
            
            System.out.println(p.mostrarLinea());
            
        }
            
        System.out.println("-------------------------------------------");
        
        System.out.println(String.format("%-25s %-15.2f %-15.2f",
                            "Total", this.totalFinanciado(), this.totalAlContado()));
    }
    
    /**
     * 
     * retorna un string con los datos solicitados
     * 
     */
    
    public String mostrarFecha(){
        
        Calendar fecha = this.getFecha();
        Locale espanol = new Locale("es", "ES");
        
        return this.getFecha().DAY_OF_MONTH + " de " + 
        this.getFecha().getDisplayName(this.getFecha().MONTH, this.getFecha().LONG, espanol);
    }
    
    /**
     * 
     * setters y getters respondables de cada atributo o v. instancia
     */
    
    private void setProductos(ArrayList p_producto) {
        
        this.productos = p_producto;
        
    }
    
    private void setFecha(Calendar p_fecha) {
        
        this.fecha = p_fecha;
        
    }
    
    private void setCliente(Cliente p_cliente) {
        
        this.clientes = p_cliente;
        
    }
    
    public ArrayList getProductos() {
        
        return this.productos;
        
    }
    
    public Calendar  getFecha() {
        
        return this.fecha;
        
    }
    
    public Cliente  getCliente() {
        
        return this.clientes;
        
    }
    
            
}