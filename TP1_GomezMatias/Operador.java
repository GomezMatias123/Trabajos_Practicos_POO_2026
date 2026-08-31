
/**
 * Write a description of class Operador here.
 * 
 * @author (Gomez Matias) 
 * @version (v1.0)
 */
public class Operador
{
    public static void main(String []args){
       int a = 8;  
       int b = 3;
       double division = (double) a/b;
       double resto = (double) a%b;
       
       //impresiones
       System.out.println("suma: "+ (a+b));
       System.out.println("resta: "+ (a-b));
       System.out.println("multiplicación: "+ (a*b));
       System.out.println("división: "+ division);
       System.out.println("resto: "+ resto);
        
    }
}