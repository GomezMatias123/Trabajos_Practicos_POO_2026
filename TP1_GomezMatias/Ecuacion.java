
/**
 * Write a description of class Ecuacion here.
 * 
 * @author (Gomez Matias) 
 * @version (V1.0)
 */
public class Ecuacion
{
    public static void main(String[]args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double discriminante = (b*b)-4*a*c;
        if(discriminante > 0) {
            System.out.println("X1= " + ((-b + Math.sqrt(discriminante))/(2*a)));
            System.out.println("X2= " + ((-b - Math.sqrt(discriminante))/(2*a)));
        } else {
            if(discriminante == 0){
                System.out.println("X1 = X2 = " + ((-b + Math.sqrt(discriminante))/(2*a)));
            } else {
                System.out.println("solución compleja (numero imaginario) ");
            }
        }
    }
}