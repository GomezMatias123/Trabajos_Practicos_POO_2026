
/**
 * Write a description of class TrianguloRectangul here.
 * 
 * @author (Matias Gomez) 
 * @version (V1.0)
 */
public class TrianguloRectangul
{
    public static void main(String []args){
        int hipotenusa = Integer.parseInt(args[0]);
        int cateto1 = Integer.parseInt(args[1]);
        int cateto2 = Integer.parseInt(args[2]);
        
        int a = hipotenusa*hipotenusa;
        int b = (cateto1*cateto1)+(cateto2*cateto2);
        
        if(a == b){
            System.out.println("Es un triangulo rectangulo");
        } else {
            System.out.println("No es un triangulo rectangulo");
        }
        
        
    }
}