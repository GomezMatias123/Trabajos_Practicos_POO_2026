import java.util.Scanner;
/**
 * Write a description of class NuevoPunto here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class NuevoPunto
{
    public static void main(String []args){
/**
* Obtamos por un diseño similar al menu basico de la clase ListaEmpleados, solo que esta clase
* cuenta con dos menus, el primero que permite al usuario elegir entre un punto standar
* inicializando sus ejes en 0, y un punto donde se puede elegir en que ejes comienza el punto.
*/ 
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        
        do{
          mostrarMenu();
          opcion = teclado.nextInt(); 
          switch(opcion){
                case 1: 
                    iniciarPuntoStandar(teclado);
                    break;
                case 2:
                    iniciarPuntoConValores(teclado);
                    break;
                case 0:
                     System.out.println("Finalizando el programa");
                    break;
                    default:
                        System.out.println("Opción inválida.");
                        

          }  
        }while(opcion !=0);
    }

    private static void mostrarMenu(){
        System.out.println("--- Selecione una opcion ---");
        System.out.println("1) Inicializar el punto en coordenadas X=0 e Y=0");
        System.out.println("2) Inicializar el punto con coordenadas personalizadas"); 
        System.out.println("0) Cerrar programa."); 
    }
/**
* Instancia el objeto nuevo punto con el constructor sin parametros para que los atributos se 
* inicialicen con el valor solicitado en la consigna y usa el mismo metodo con un do-while y
* un switch para poder crear un menu interactivo basico para un usuario.
*/    
    private static void iniciarPuntoStandar(Scanner teclado){
        teclado.nextLine();
        Punto nuevoPunto = new Punto();
        
        int decision = -1;
        
        do{
        System.out.println("1) Deslplazar el punto por los ejes X e Y");
        System.out.println("2) Mostrar las coordenadas actuales del punto"); 
        System.out.println("0) Volver al menu principal"); 
        System.out.println("Coordenadas actuales: " + nuevoPunto.coordenadas()); 
        decision = teclado.nextInt();
        
        switch(decision){
            case 1:
                teclado.nextLine();
                System.out.println("Ingrese la cantidad de variacion para el eje X");
                double x = teclado.nextDouble();
                System.out.println("Ingrese la cantidad de variacion para el eje Y");
                double y = teclado.nextDouble();
                nuevoPunto.desplazar(x, y);
                break;
            case 2:
                nuevoPunto.mostrar();
                break;
            case 0:
                System.out.println("Deteniendo el programa");
                    break;
                    default:
                        System.out.println("Opción inválida.");
        }
            
        }while(decision!= 0);
    }
    /**
* Instancia el objeto nuevo punto con el constructor y los parametros ingresado por teclado
* con la clase Scanner. Los atributos inicializan con el valor solicitado por el usuario 
* y usa el mismo metodo con un do-while y un switch para poder crear un menu interactivo 
* basico para un usuario.
*/   

    
     private static void iniciarPuntoConValores(Scanner teclado){
        teclado.nextLine();
        System.out.println("Ingrese el valor del eje X");
        double coordenadaX = teclado.nextDouble();
        System.out.println("Ingrese el valor del eje Y");
        double coordenadaY = teclado.nextDouble();
        Punto nuevoPunto = new Punto(coordenadaX, coordenadaY);
        
        int decision = -1;
        
        do{
        System.out.println("1) Deslplazar el punto por los ejes X e Y");
        System.out.println("2) Mostrar las coordenadas actuales del punto"); 
        System.out.println("0) Volver al menu principal"); 
        System.out.println("Coordenadas actuales: " + nuevoPunto.coordenadas());
        teclado.nextLine();
        decision = teclado.nextInt();
        
        switch(decision){
            case 1:
                teclado.nextLine();
                System.out.println("Ingrese la cantidad de variacion para el eje X");
                double x = teclado.nextDouble();
                System.out.println("Ingrese la cantidad de variacion para el eje Y");
                double y = teclado.nextDouble();
                nuevoPunto.desplazar(x, y);
                break;
            case 2:
                nuevoPunto.mostrar();
                break;
            case 0:
                System.out.println("Deteniendo el programa");
                    break;
                    default:
                        System.out.println("Opción inválida.");
        }
        }while(decision!= 0);
    }
}