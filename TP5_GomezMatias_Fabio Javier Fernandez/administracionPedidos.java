import java.util.ArrayList;

/**
 * La clase administracionPedidos, es el ejecutable para realizar pruebas en los pedidos de etiquetas.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class administracionPedidos
{
    public static void main(String []args){
        
        ArrayList <Renglon> pedidos = new ArrayList<>();
        
        Etiqueta etiqueta1 = new Premiun(10,200);
        Renglon renglon1 = new Renglon(7, etiqueta1);
        Etiqueta etiqueta2 = new Comun(100);
        Renglon renglon2 = new Renglon(57, etiqueta2);
        Etiqueta etiqueta3 = new Premiun(7,200);
        Renglon renglon3 = new Renglon(94, etiqueta3);
        
        pedidos.add(renglon1);
        pedidos.add(renglon2);
        pedidos.add(renglon3);
        
        Pedido pedidoPrueba = new Pedido(pedidos);
        
        pedidoPrueba.mostrar();
        
    }
}