import java.util.Scanner;
/**
 * Write a description of class ArrayDePuntos here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class ArrayDePuntos {
    
    public static void main(String[] args) {
        
        Punto[] puntos = new Punto[6]; 
        Scanner teclado = new Scanner(System.in);
        
        insertarPuntos(puntos, teclado);
        mostrarPuntos(puntos);
        
        
    }
    
    public static void insertarPuntos(Punto[] puntos, Scanner teclado) {
        
        for(int i = 0; i < puntos.length; i++) {
            
            System.out.println("Punto " + (i+1));
            System.out.println("Ingrese la coordenada X: ");
            int x = teclado.nextInt();
            System.out.println("Ingrese la coordenada Y: ");
            int y = teclado.nextInt();
            
            puntos[i] = new Punto(x, y);
            
        }
    }
    
    public static void mostrarPuntos(Punto[] puntos) {
        
        for (int i = 0; i < puntos.length ; i++) {
            
            System.out.println("Punto: " + (i + 1));
            puntos[i].mostrar();
            
            if(i != puntos.length-1) {
                
                System.out.println("Distancia del punto " + (i+1) + " al punto: " + (i + 2) + ": " + puntos[i].distanciaA(puntos[i+1]));
                
            }
            
        }
    }
}