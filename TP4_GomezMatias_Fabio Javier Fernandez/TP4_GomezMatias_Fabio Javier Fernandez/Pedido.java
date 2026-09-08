import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido {
    
    //atributos
    
    private Calendar fecha;
    private ArrayList<Producto> productos;
    private Cliente clientes;
    
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList<Producto> p_productos) {
        
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
                      
    }
    
    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_productos) {
        
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
                      
    }
    
    public double totalAlContado() {
        
        for(Producto p : this.getProductos()) {
            
            double acumulador;
            
            acumulador += p.precioContado();
            
        }
    }
    
    public double totalFinanciado() {
        
        for(Producto p : this.getProductos()) {
            
            double acumulador;
            
            acumulador += p.precioLista();
            
        }
    }
    
    public boolean agregarProducto(Producto p_producto) {
        Producto ingresoProducto = p_producto;
        productos.add(ingresoProducto);
        if(productos.contains(ingresoProducto)){
            return true;
        }else {
            return false;
        }
        
    }
    
    public boolean quitarProducto(Producto p_producto) {
        Producto  retiroProducto = p_producto;
        productos.remove(retiroProducto);
        if(productos.contains(retiroProducto)){
            return false;
        }else {
            return true;
        }
        
    }
    
    
    
}