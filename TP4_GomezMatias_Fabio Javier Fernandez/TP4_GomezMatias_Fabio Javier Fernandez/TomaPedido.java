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
          mostrarListaProductos(p);
          
          System.out.println("--- Iniciar pedido ---");
          imprimirDetallePedido(p, teclado);
          
          
          
          
          
          
      }
      
      
      public static void crearListaProductos(ArrayList<Producto> p, Scanner teclado){
          
          int option = -1;
          while(option != 0){
              System.out.println("Ingrese codigo del producto");
              int cod = teclado.nextInt();
              teclado.nextLine();
              System.out.println("Ingrese rubro al que pertenece el producto");
              String rubro = teclado.nextLine();
              System.out.println("Ingrese descripcion del producto");
              String descripcion = teclado.nextLine();
              System.out.println("Ingrese el costo");
              double costo = teclado.nextDouble();
              teclado.nextLine();
              String rep2 = "n";
              System.out.println("¿Desea ingresar un limte para reposicion y existencia minima del producto? (Y = si, N = no");
              rep2 = teclado.nextLine();
              double porcRepo = 0;
              int exisMinima = 0;
              if (rep2.equals("Y") || rep2.equals("y")){ 
              System.out.println("Ingrese la porcentaje para reposicion");
              porcRepo = teclado.nextDouble();
              System.out.println("Ingrese la cantidad limite de existencia minima");
              exisMinima = teclado.nextInt();
              teclado.nextLine();
              }
              System.out.println("Ingrese el nombre del laboratorio al que pertenece");
              String nomLab = teclado.nextLine();
              System.out.println("Ingrese el domicilio del laboratorio");
              String domLab = teclado.nextLine();
              System.out.println("Ingrese el telefono del laboratorio al que pertenece");
              String telLab = teclado.nextLine();
              
                  Laboratorio lab = new Laboratorio(nomLab, domLab, telLab);
                  Producto nuevoProducto;
                  if (rep2.equals("Y") || rep2.equals("y")){     
                 nuevoProducto = new Producto(cod, rubro, descripcion, costo, porcRepo, exisMinima, lab);
                } else {
                 nuevoProducto = new Producto(cod, rubro, descripcion, costo, lab);   
                }
                p.add(nuevoProducto);
                System.out.println("Ingrese 1 para seguir añadiendo productos o 0 para salir");
                option = teclado.nextInt();
            }
          }
          
      public static void mostrarListaProductos(ArrayList<Producto> p){
           if(p.isEmpty()){
            System.out.println("--- Lista vacia ---");
            return;
        } else {
            System.out.println("-----------------------------------");
            System.out.println("--- Listado de prodcutos ---");
            for(int i = 0;i < p.size();i++){
                Producto producto = p.get(i);
                System.out.println((i+1) + ") " + producto.mostrarLinea());
            }
            System.out.println("-----------------------------------");
        }
      }
         
      public static Pedido crearPedido(ArrayList<Producto> p, Scanner teclado){
          teclado.nextLine();
          ArrayList <Producto> listaPedido = new ArrayList<>();
          System.out.println("ingrese su nombre");
          String nomCliente = teclado.nextLine();
          System.out.println("ingrese su apellido");
          String apeCliente = teclado.nextLine();
          System.out.println("ingrese su DNI");
          int dni = teclado.nextInt();
          teclado.nextLine();
          System.out.println("ingrese su saldo actual");
          double saldo = teclado.nextDouble();
          teclado.nextLine();
          Cliente cliente = new Cliente(dni, apeCliente, nomCliente, saldo);
          int option = -1;
          Calendar fechaHoy = Calendar.getInstance();
          while(option != 0) {
            System.out.println("ingrese el numero del producto que desea incorporar a su pedido");
            int indiceProducto = teclado.nextInt();
            Producto producto = p.get(indiceProducto - 1);
            listaPedido.add(producto);
            System.out.println("ingrese 1 para seguir eligiendo pedidos o 0 para imprimir el detalle del pedido");
            option = teclado.nextInt();
          }
          teclado.nextLine(); 
          Pedido nuevoPedido = new Pedido(fechaHoy, cliente, listaPedido);
          return nuevoPedido;
      }
      
      public static void imprimirDetallePedido(ArrayList<Producto> p, Scanner teclado){
          Pedido pedidoActual = crearPedido(p, teclado);
          int respuesta = - 1;
          while(respuesta != 0){
            pedidoActual.mostrar();
            System.out.println("Si desea quitar un producto de la lista presione 1, para confirmar el pedido presione 0");
            respuesta = teclado.nextInt();
            teclado.nextLine();
            if(respuesta != 0){
                System.out.println("Indique con el indice que producto desea quitar");
                int indiceProducto = teclado.nextInt();
                Producto ProductoRemovido = pedidoActual.getProductos().get(indiceProducto - 1);
                System.out.println(pedidoActual.quitarProducto(ProductoRemovido) ? "Producto removido con exito" : "Fallo en remover el producto");
            }
          }
          System.out.println("++++++++++++++++");
          System.out.println("Gracias por comprar");
          System.out.println("++++++++++++++++");
      }
      }
