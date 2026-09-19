import java.util.*;
import java.util.ArrayList;

/**
 * Es una abtraccion un pedido realizado por un cliente.
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
        
        ArrayList<Producto> p = new ArrayList<>();
        p.add(p_productos);
        
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p);
                      
    }
    
    public double totalAlContado() {
        
        double acumulador = 0;
        
        for(Producto p : this.getProductos()) {
            
            acumulador += p.precioContado();
            
        }
        
        return acumulador;
    }
    
    public double totalFinanciado() {
        
        double acumulador = 0;
        
        for(Producto p : this.getProductos()) {
            
            acumulador += p.precioLista();
            
        }
        
        return acumulador;
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
    
    public void mostrar() {
        
        System.out.println("******Detalle de pedido****** " + 
                           this.mostrarFecha());
        System.out.println(String.format("%-25s %-15s %-15s", "Producto", "Precio Lista", "Precio Contado"));
        
        System.out.println("-------------------------------------------");
        for(Producto p : this.getProductos()) {
            
            System.out.println(p.mostrarLinea());
            
        }
            
        System.out.println("-------------------------------------------");
        
        System.out.println(String.format("%-25s %-15.2f %-15.2f",
                            "Total", this.totalFinanciado(), this.totalAlContado()));
    }
    
    public String mostrarFecha(){
        
        Calendar fecha = this.getFecha();
        Locale espanol = new Locale("es", "ES");
        
        return this.getFecha().DAY_OF_MONTH + " de " + 
        this.getFecha().getDisplayName(this.getFecha().MONTH, this.getFecha().LONG, espanol);
    }
    
    private void setProductos(ArrayList<Producto> p_producto) {
        
        this.productos = p_producto;
        
    }
    
    private void setFecha(Calendar p_fecha) {
        
        this.fecha = p_fecha;
        
    }
    
    private void setCliente(Cliente p_cliente) {
        
        this.clientes = p_cliente;
        
    }
    
    public ArrayList<Producto>  getProductos() {
        
        return this.productos;
        
    }
    
    public Calendar  getFecha() {
        
        return this.fecha;
        
    }
    
    public Cliente  getCliente() {
        
        return this.clientes;
        
    }
    
            
}