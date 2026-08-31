
/**
 * Write a description of class Multiplo here.
 * 
 * @author (Gomez Matias) 
 * @version (v1.0)
 */
public class Multiplo
{
  public static void main(String []args){
        System.out.println("Multiplos de 4 entrel 42 y 150");
      for(int i = 42;i <= 150;i++){
          if(i % 4 == 0){
              System.out.println(i);
          }
      }
  }
}