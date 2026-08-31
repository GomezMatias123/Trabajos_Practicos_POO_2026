import java.util.Scanner;
/**
 * Write a description of class OrdenVector here.
 * 
 * @author (Matias Gomez) 
 * @version (V1.0)
 */
public class OrdenVector
{
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        double []numeros= new double[4];
        for(int i = 0;i < numeros.length;i++){
             System.out.println("Elemento" + (i+1) + "=");
             int numero = teclado.nextInt();
             numeros[i] = numero;
         }
         //Mostrar lista desordenada
        System.out.print("Lista desordenada: ");
         for(int i = 0; i < numeros.length; i++){
             System.out.print(numeros[i] + "\t");
         }
         System.out.println();
        
        for(int i = 0; i < numeros.length-1; i++){
            for(int j = 0; j < numeros.length-1; j++){
                if(numeros[j]> numeros[j+1]){
                    double aux = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = aux;
                }
            }
        }
         //Mostrar lista ordenada
        System.out.print("Lista ordenada: ");
         for(int i = 0; i < numeros.length; i++){
             System.out.print(numeros[i] + "\t");
         }
         System.out.println();
        System.out.println("Elemento de menor valor: " + numeros[0]);
         
         
         
    }
}