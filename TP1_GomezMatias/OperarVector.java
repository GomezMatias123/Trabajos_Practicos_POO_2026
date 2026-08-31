import java.util.Scanner;
/**
 * Write a description of class OperarVector here.
 * 
 * @author (Matias Gomez) 
 * @version (V1.0)
 */
public class OperarVector
{
     public static void main(String[]args){
         Scanner teclado = new Scanner(System.in);
         int []notas = new int[5];
         double sumarNotas = 0;
         double promedio;
         int notaMayor = 0;
         
         for(int i = 0;i < notas.length;i++){
             System.out.println("Nota " + (i+1) + "=");
             int nota = teclado.nextInt();
             notas[i] = nota;
             sumarNotas = sumarNotas + (double)nota;
         }
         promedio = sumarNotas/notas.length;
         
         for(int i = 0; i < notas.length; i++){
             if(notas[i] > notaMayor){
                 notaMayor = notas[i];
             }
         }
         
         //Mostrar
         System.out.print("Notas ingresadas: ");
         for(int i = 0; i < notas.length; i++){
             System.out.print(notas[i] + "\t");
         }
         System.out.println();
         
         System.out.println("Promedio = " + promedio);
         System.out.println("Mayor nota = " + notaMayor);
     }
}