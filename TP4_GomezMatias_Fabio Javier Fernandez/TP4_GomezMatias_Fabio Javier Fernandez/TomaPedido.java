import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Es una abstraccion de un pedido que fue tomado por parte de un cliente.
 * 
 * @author (Gomez Matias, Fernandez Fabio Javier) 
 * @version (V1.0)
 */
public class TomaPedido
{
      public static void main(String[] args){
          ArrayList <Producto> p = new ArrayList<>();
          Scanner teclado = new Scanner(System.in);
          crearListaProductos(p, teclado);
         
          System.out.println("--- Iniciar pedido ---");
          
          Calendar fechaHoy = Calendar.getInstance();
          
          
          
          
          
      }
      
      
      public static void crearListaProductos(ArrayList<Producto> p, Scanner teclado){
          
          int option = -1;
          while(option != 0){
              System.out.println("Ingrese codigo del producto");
              int cod = teclado.nextInt();
              System.out.println("Ingrese rubro al que pertenece el producto");
              String rubro = teclado.nextInt();
              
              
              
              Producto(int p_codigo, String  p_rubro, String p_desc, double p_costo, 
              double p_porcPtoRepo, int p_existMinima, Laboratorio p_laboratorio)
          }
          
          
      }
}