import java.util.Scanner;
import java.util.ArrayList;

/**
 * Clase ejecutable de la clase Punto
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class NuevoPunto
{
    public static void main(String []args){
        /**
         * 
        * Utilizamos un modelo similar a la anterior clase Nuevo punto, adaptado para el manejo un array 
        * en el que se almacenan los puntos
        * 
        */ 
        Scanner teclado = new Scanner(System.in);
        ArrayList <Punto> puntos = new ArrayList<>();
        int opcion = -1;
        
        do{
          mostrarMenu();
          opcion = teclado.nextInt(); 
          switch(opcion){
                case 1: 
                    iniciarPuntoStandar(puntos);
                    break;
                case 2:                       
                        iniciarPuntoConValores(args, puntos);
                    break;
                case 3: 
                    calcularDistancia(teclado, puntos);
                    break;
                case 4: 
                    mostrarLista(puntos);
                    break;
                case 5: 
                    ajustarCoordenadas(teclado, puntos);

                
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
        System.out.println("2) Inicializar el punto con las coordenadas personalizadas"); 
        System.out.println("3) Calcular distancia entre dos puntos");
        System.out.println("4) Mostrar Lista de puntos");
        System.out.println("5) Ajustar Coordenadas");
        System.out.println("0) Cerrar programa."); 
    }
    
    /**
    * 
    * Instancia el objeto nuevo punto con el constructor sin parametros para que los atributos se 
    * inicialicen con el valor solicitado en la consigna
    * 
    */    
    private static void iniciarPuntoStandar(ArrayList<Punto> p_puntos){
        
            Punto nuevoPunto = new Punto();
             
            p_puntos.add(nuevoPunto);
            
            System.out.println("El punto se ha añadido!");
            
    }
        
     /**
    * Instancia el objeto nuevo punto con el constructor y los parametros ingresado por teclado
    * el argumento main. Los atributos inicializan con el valor solicitado por el usuario 
    *  
    */   
    
   private static void iniciarPuntoConValores(String[] args,ArrayList<Punto> p_puntos){
       
        
       if((args.length % 2) != 0) {
           
           String[] auxArgs = new String[args.length + 1];
           
           for(int i=0; i<args.length;i++) {
               
               auxArgs[i] = args[i];
               
           }
           
           auxArgs[args.length] = "0";
           
           args = auxArgs;
           
           
       }
       
        for(int i=0; i<args.length; i += 2) {
               
            Punto nuevoPunto = new Punto( Double.valueOf(args[i]) , Double.valueOf(args[i+1]));
            p_puntos.add(nuevoPunto);
               
        }
           
       
       System.out.println("Los puntos se han añadido!");
          
    }
        
    private static void calcularDistancia(Scanner teclado, ArrayList<Punto> p_puntos){
        
        int indice;
        Punto punto1, punto2;
        
        if(p_puntos.isEmpty()) {
            
            System.out.println("--La lista esta vacia..--");
            
        }else {
            
            System.out.println("--Ingrese los indices de los puntos: ");
            System.out.println("--(Revisar lista en caso de no conocerlos)");
            System.out.println("--punto 1: ");
            
            indice = teclado.nextInt();
            punto1 = p_puntos.get(indice - 1);
            
            System.out.println("--punto 2: ");
            
            indice = teclado.nextInt();
            punto2 = p_puntos.get(indice - 1);
            
            System.out.println("Distancia del punto 1 al punto 2: " +   punto1.distanciaA(punto2));
        
        }
    }
    
    private static void mostrarLista(ArrayList<Punto> p_puntos) {
        
        Punto puntoActual;
        
        if(p_puntos.isEmpty()) {
            
            System.out.println("--La lista esta vacia..--");
            
        }else {
            
            for(int i=0; i < p_puntos.size(); i++) {
                
                System.out.print((i+1) + ")");
                puntoActual = p_puntos.get(i);
                
                puntoActual.mostrar();
                
            }
        
        }

    } 
    
    private static void ajustarCoordenadas(Scanner teclado, ArrayList<Punto> p_puntos) {
        
        int indice;
        Punto punto;
        
        if(p_puntos.isEmpty()) {
            
            System.out.println("--La lista esta vacia..--");
            
        }else {
            
            System.out.println("--Ingrese el indice del punto: ");
            System.out.println("--(Revisar lista en caso de no conocerlos)");
            
            indice = teclado.nextInt();
            punto = p_puntos.get(indice - 1);
            
            System.out.println("Ingrese la cantidad de variacion para el eje X");
            double x = teclado.nextDouble();
            System.out.println("Ingrese la cantidad de variacion para el eje Y");
            double y = teclado.nextDouble();
            
            punto.desplazar(x, y);
            
            System.out.println("Coordenadas actuales: " + punto.coordenadas());
        
        }
    }   
}