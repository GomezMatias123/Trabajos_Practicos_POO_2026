import java.util.Scanner;
/**
 * Write a description of class Circunferencia here.
 * 
 * @author (Matias Gomez) 
 * @version (v1.0)
 * En la elaboracion de la resolucion se prefirio usar printf con "%.2f%n" para redondear
 * los resultados con decimales extensos.
 * Modificacion para el ingreso de datos por teclado y la posibildad de calcular el perimetro de
 * varias circunferencias.
 */
public class Circunferencia
{
    public static void main(String []args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese Y para poder calcular el perimetro de una circunferencia con su radio, N para cerrar la app");
        String repuesta = teclado.next();
        while(repuesta.equalsIgnoreCase("Y")){
            System.out.println("ingrese el valor del radio");
            int radio = teclado.nextInt();
            
            double perimetro = 2 * Math.PI * (double)radio;
            System.out.printf("Perimetro: %.2f%n", perimetro);
            
            System.out.println("¿Desea continuar calculando? Y/N");
            repuesta = teclado.next();
            }
            System.out.println("Fin del programa");
    }
}